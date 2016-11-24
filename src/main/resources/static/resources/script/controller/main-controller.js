/**
 * Created by dongzekun.
 * Date: 16/9/21
 * Time: 19:41
 */
shaka.controller("LeftMenuController", function ($scope, $location) {
    $scope.$on(
        "$routeChangeSuccess",
        function () {
            $scope.getPath();
        }
    );
    $scope.goto = function (path) {
        $location.path(path);
        var params = $location.search();
        if (params == null && params.length <= 0) {
            return;
        }
        $scope.getPath();
        var menus = $scope.leftMenu;
        //remove params
        for (var i = 0; i < menus.length; i++) {
            if (menus[i].path == path) {
                for (var key in params) {
                    if (menus[i].keep && menus[i].keep.indexOf(key) < 0) {
                        delete params[key];
                    }
                }
            }
            if (menus[i].sub) {
                for (var j = 0; j < menus[i].sub.length; j++) {
                    var sp = menus[i].sub[j];
                    if (sp.path == path) {
                        for (var key in params) {
                            if (sp.keep && sp.keep.indexOf(key) < 0) {
                                delete params[key];
                            }
                        }
                    }
                }
            }
        }
        $location.search(params);
    };
    $scope.getPath = function () {
        $scope.path = $location.path();
        $scope.leftMenu = leftMenu;
    };
    $scope.init = function () {
        $scope.getPath();
    };

    $scope.init();
});