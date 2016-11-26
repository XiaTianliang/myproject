var marketPro = angular.module("marketPro", ["ngRoute", "DataLoad"]);
/**
 * define all uri route rules
 */
marketPro.config(["$routeProvider",
    function ($routeProvider) {
        $routeProvider.when("/district", {
                templateUrl: 'views/district.html',
                reloadOnSearch: false
            }
        ).when("/supplier", {
                templateUrl: 'views/supplier.html',
                reloadOnSearch: false
            }
        ).when("/center", {
                templateUrl: 'views/distribution_center.html',
                reloadOnSearch: false
            }
        ).when("/supermarket", {
                templateUrl: 'views/supermarket.html',
                reloadOnSearch: false
            }
        ).when("/centerPurchaseOrder", {
                templateUrl: 'views/center_purchase_order.html',
                reloadOnSearch: false
            }
        ).when("/marketCenterOrder", {
                templateUrl: 'views/market_center_order.html',
                reloadOnSearch: false
            }
        ).when("/centerInventory", {
                templateUrl: 'views/center_inventory.html',
                reloadOnSearch: false
            }
        ).when("/marketInventory", {
                templateUrl: 'views/market_inventory.html',
                reloadOnSearch: false
            }
        )
    }]);

