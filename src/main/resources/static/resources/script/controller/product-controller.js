marketPro.controller("productController", function ($scope, $q, DataLoadService) {
    // $scope.selectConfigType = function (item, key, value) {
    //     item[key]=value;
    // };
    $scope.createProduct = function () {
        popupOpen("#productModal",
            function () {
                $scope.product = {};
                $scope.product.countryNames = $scope.countryNames;
            }, function () {
                $scope.renderProduct();
            });
    };
    $scope.editProduct = function (item) {
        popupOpen("#productModal", function () {
                $scope.product = item;
            }, function () {
                $scope.renderProduct();
            }
        );
    };

    $scope.deleteProduct = function (item) {
        $q.when(DataLoadService.del("/product/"+item.productMstId,"Delete the product?",
            $scope.renderProduct)).then(function (response) {
        })
    };

    $scope.saveProduct = function (product) {
        $q.when(DataLoadService.save("/product", product, function () {
            popupClose();
        }, swalFailure));
    };

    $scope.renderProduct = function () {
        $q.when(DataLoadService.get("/product")).then(function (response) {
            $scope.products = response.data;
        })
    };

    $scope.init = function () {
        $scope.renderProduct();
    };

    $scope.init();

});
