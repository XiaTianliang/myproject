marketPro.controller("inventoryController", function ($scope, $q, DataLoadService) {
    $scope.editSimpleModel = function (inventory) {
        $scope.inventory = inventory;
        popupOpen("#simpleModelModal",
            function () {
                if(!$scope.inventory.modelConfig){
                    $scope.inventory.modelConfig={};
                }
                $scope.inventory.model = angular.fromJson($scope.inventory.modelConfig);
            }, function () {
            });
    };
    $scope.editCustomerModel = function (inventory) {
        $scope.inventory = inventory;
        popupOpen("#customerModelModal",
            function () {
                if(!$scope.inventory.modelConfig){
                    $scope.inventory.modelConfig={};
                }
                $scope.inventory.model = angular.fromJson($scope.inventory.modelConfig);
            }, function () {
            });
    };

    $scope.onReplenishmentModelStatusClick = function (item, status) {
        item.replenishmentModelStatus = status;
        $scope.saveInventory(item);
    };

    $scope.saveInventory = function (inventory) {
        inventory.modelConfig = angular.toJson(inventory.model);
        $q.when(DataLoadService.save("/inventory", inventory, function () {
            popupClose();
        }, swalFailure));
    };

    //Valu
    //event type
    $scope.addField = function () {
        if(!$scope.inventory.model.map){
            $scope.inventory.model.map={};
        }
        $scope.inventory.model.map[$scope.fieldName]=Object.assign({}, $scope.field);
        $scope.field = {};
        $scope.fieldName='';
    };
    $scope.deleteField = function (key) {
        delete $scope.inventory.model.map[key];
    };
    $scope.editField = function (key) {
        $scope.fieldName = key;
        $scope.field = $scope.inventory.model.map[key];
        $scope.deleteField(key);
    };

    $scope.renderInventory= function () {
        $q.when(DataLoadService.get("/inventory")).then(function (response) {
            $scope.inventories = response.data;
        })
    };

    $scope.init = function () {
        //$scope.replenishmentModelStatuses = $rootScope.statusMap['replenishmentModelStatus'];
        $scope.replenishmentModelStatuses=['NO_MODEL','SIMPLE_MODEL','CUSTOMIZED_MODEL'];
        $scope.renderInventory();
    };

    $scope.init();
});
