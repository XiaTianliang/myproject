marketPro.controller("marketInventoryController", function ($scope, $q, DataLoadService) {
    $scope.renderMarketInventory = function () {
        $q.when(DataLoadService.get("/commodity/marketInventory")).then(function (response) {
            $scope.marketInventories = response.data;
        })
    };

    $scope.init = function () {
        $scope.renderMarketInventory();
    };

    $scope.init();

});
