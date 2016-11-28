var marketPro = angular.module("marketPro", ["ngRoute", "DataLoad"]);
/**
 * define all uri route rules
 */
marketPro.config(["$routeProvider",
    function ($routeProvider) {
        $routeProvider
            .when("/product", {
                templateUrl: 'views/product.html',
                reloadOnSearch: false
            }
        ).when("/purchase_inventory", {
                    templateUrl: 'views/purchase_inventory.html',
                    reloadOnSearch: false
                }
        ).when("/sales", {
                templateUrl: 'views/sales.html',
                reloadOnSearch: false
            }
        )
    }]);

