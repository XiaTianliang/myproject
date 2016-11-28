marketPro.controller("purchaseInventoryController", function ($scope, $q, DataLoadService) {
    $scope.createPurchase = function () {
        popupOpen("#purchaseModal",
            function () {
                $scope.purchase = {};
            }, function () {
                $scope.renderPurchase();
            });
    };

    $scope.editSimpleModel = function () {
        popupOpen("#sampleModelModal",
            function () {
                $scope.simpleModel = {};
            }, function () {
                $scope.renderPurchase();
            });
    };

    $scope.saveSimpleModel = function (purchase) {
        $q.when(DataLoadService.save("/model/simpleModel", purchase, function () {
            popupClose();
        }, swalFailure));
    };

    $scope.savePurchase = function (purchase) {
        $q.when(DataLoadService.save("/purchase", purchase, function () {
            popupClose();
        }, swalFailure));
    };

    $scope.renderPurchase = function () {
        $q.when(DataLoadService.get("/purchase")).then(function (response) {
            $scope.purchases = response.data;
        })
    };

    $scope.renderInventory= function () {
        $q.when(DataLoadService.get("/inventory")).then(function (response) {
            $scope.inventories = response.data;
        })
    };



    $scope.init = function () {
        $scope.renderPurchase();
        $scope.renderInventory();
    };

    $scope.init();

});
