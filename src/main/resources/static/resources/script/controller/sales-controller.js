marketPro.controller("SalesController", function ($scope, $q, DataLoadService) {
    $scope.createSales = function () {
        popupOpen("#salesModal",
            function () {
                $scope.sales = {};
            }, function () {
                $scope.renderSales();
            });
    };

    $scope.saveSales = function (sales) {
        $q.when(DataLoadService.save("/sales", sales, function () {
            popupClose();
        }, swalFailure));
    };

    $scope.renderSales = function () {
        $q.when(DataLoadService.get("/sales")).then(function (response) {
            $scope.saleses = response.data;
        })
    };

    $scope.init = function () {
        $scope.renderSales();
    };

    $scope.init();

});
