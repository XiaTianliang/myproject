/**
 * @author tianliangxia
 *     Date:16-11-30
 *     Time:上午12:11
 */
marketPro.controller("statusController", function ($scope, $q, DataLoadService) {
    $scope.init = function () {
    //     $q.when(DataLoadService.get("/status")).then(function (response) {
    //         $rootScope.statusMap = response.data;
    //         console.log(response.data);
    //     })
    };
    $scope.init();
});
