/**
 * Created by xiatianliang on 16/8/8.
 */
shaka.controller("clusterController", function ($scope, $q, DataLoadService) {
    $scope.createCluster = function () {
        popupOpen("#clusterModal",
            function () {
                $scope.cluster = {};
            }, function () {
                $scope.getContainerInfoAndClusters();
            });
    };
    $scope.editCluster = function (item) {
        popupOpen("#clusterModal", function () {
                $scope.cluster = item;
            }, function () {
                $scope.getContainerInfoAndClusters();
            }
        );
    };
    $scope.unDeploy = function (cluster) {
        $q.when(DataLoadService.put("/cluster/" + cluster.id + "/undeploy")).then(function (response) {
            swalSuccess('Undeploy ' + cluster.name + ' success');
            $scope.getContainerInfoAndClusters();
        }, function (response) {
            console.log(response);
            swalFailure(response);
            $scope.getContainerInfoAndClusters();
        });
    };
    $scope.deploy = function (cluster) {
        $q.when(DataLoadService.put("/cluster/" + cluster.id + "/deploy")).then(function (response) {
            swalSuccess('Deploy ' + cluster.name + ' success');
            $scope.getContainerInfoAndClusters();
        }, function (response) {
            console.log(response);
            swalFailure(response);
            $scope.getContainerInfoAndClusters();
        });
    };
    $scope.deployClick = function (cluster) {
        //give warning if cluster.containerSize > container.freeSize
        if (cluster.containerSize > $scope.container.freeSize) {
            swal({
                type: 'warning',
                title: 'Container size(' + cluster.containerSize + ") is bigger than free container size("
                + $scope.container.freeSize + "), deploy anyway?",
                showCancelButton: true,
                confirmButtonText: 'Yes, deploy it!'
            }).then(function () {
                $scope.deploy(cluster);
            }).done();
        } else {
            $scope.deploy(cluster);
        }
    };
    $scope.checkName = function (name) {
        if ($scope.cluster.id)
            return;

        var clusters = $scope.clusters.filter(function (obj) {
            if (name === obj.name)
                return obj;
        });
        $scope.cluster.nameError = (!name) || (clusters.length > 0);
    };
    $scope.saveCluster = function () {
        $q.when(DataLoadService.save("/cluster", $scope.cluster, function () {
            popupClose();
        }, swalFailure));
    };
    $scope.renderClusterList = function () {
        $q.when(DataLoadService.get("/cluster")).then(function (response) {
            $scope.clusters = response.data;
        });
    };
    $scope.deleteCluster = function (item) {
        DataLoadService.del("/cluster/" + item.id, "Are sure delete cluster [" + item.name + "]?", $scope.renderClusterList);
    };
    $scope.getContainerInfo = function () {
        // $q.when(DataLoadService.get("/masterInfo")).then(function (response) {
        //     var MASTER_ADDRESS = "/proxy?url=http://" + response.data.containerKey;
        //     $q.when(DataLoadService.get(MASTER_ADDRESS + "/master")).then(function (response) {
        //         $scope.masterContext = response.data.masterContext;
        //         $scope.setContainerSize($scope.masterContext.usedContainers.length,
        //             $scope.masterContext.freeContainers.length);
        //     }, function (response) {
        //         //connect refused
        //         console.log(response);
        //         $scope.setContainerSize(0, 0);
        //     });
        // }, function (response) {
        //     //no master
        //     console.log(response);
        //     $scope.setContainerSize(0, 0);
        // });
    };
    $scope.setContainerSize = function(usedSize, freeSize){
        $scope.container = {};
        $scope.container.usedSize = usedSize;
        $scope.container.freeSize = freeSize;
    };
    $scope.getContainerInfoAndClusters = function () {
        $scope.getContainerInfo();
        $scope.renderClusterList();
    };
    $scope.init = function () {
        $scope.getContainerInfoAndClusters();
    };
    $scope.init();

});