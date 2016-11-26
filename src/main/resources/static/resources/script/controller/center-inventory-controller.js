marketPro.controller("centerInventoryController", function ($scope, $q, DataLoadService) {
    $scope.renderCenterInventory = function () {
        $q.when(DataLoadService.get("/commodity/centerInventory")).then(function (response) {
            $scope.centerInventories = response.data;
        })
    };

    $scope.init = function () {
        $scope.renderCenterInventory();
    };

    $scope.init();

});
