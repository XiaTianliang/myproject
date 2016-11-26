marketPro.controller("distributionCenterController", function ($scope, $q, DataLoadService) {
    $scope.selectConfigType = function (item, key, value) {
        item[key]=value;
    };

    $scope.createCenter = function () {
        popupOpen("#centerModal",
            function () {
                $scope.center = {};
                $scope.center.countryNames = $scope.countryNames;
            }, function () {
                $scope.renderCenter();
            });
    };
    $scope.editCenter = function (item) {
        popupOpen("#centerModal", function () {
                $scope.center = item;
                //transfer address to countryName, stateName, cityName
                var tmp = $scope.center.address.split(":");
                $scope.center.countryName = tmp[0];
                $scope.center.stateName = tmp[1];
                $scope.center.cityName = tmp[2];
                $scope.center.countryNames = $scope.countryNames;
                $scope.getStateNamesByCountry($scope.center);
            }, function () {
                $scope.renderCenter();
            }
        );
    };

    $scope.getStateNamesByCountry = function (center) {
        //update stateNames in center according to country name
        for(var idx in $scope.countries){
            if($scope.countries[idx]['name'] == center.countryName){
                center.countryId = $scope.countries[idx]['id'];
                break;
            }
        }
        if(center.countryId){
            $q.when(DataLoadService.get("/district/state/countryId/"+center.countryId)).then(function (response) {
                center.states = response.data;
                center.stateNames = [];
                center.states.forEach(function (entry) {
                    center.stateNames.push(entry.name);
                })
            })
        }
    };

    $scope.getCityNamesByState = function (center) {
        //update stateNames in center according to country name
        for(var idx in center.states){
            if(center.states[idx]['name'] == center.stateName){
                center.stateId = center.states[idx]['id'];
                break;
            }
        }
        $q.when(DataLoadService.get("/district/city/stateId/"+center.stateId)).then(function (response) {
            center.cities = response.data;
            center.cityNames = [];
            center.cities.forEach(function (entry) {
                center.cityNames.push(entry.name);
            })
        })
    };

    $scope.deleteCenter = function (item) {
        $q.when(DataLoadService.del("/commodity/center/"+item.id,"Delete the center?",
            $scope.renderCenter)).then(function (response) {
        })
    };

    $scope.saveCenter = function (center) {
        for(var idx in center.cities){
            if(center.cities[idx]['name'] == center.cityName){
                center.cityId = center.cities[idx]['id'];
                break;
            }
        }
        $q.when(DataLoadService.save("/commodity/center", center, function () {
            popupClose();
        }, swalFailure));
    };

    $scope.renderCenter = function () {
        $q.when(DataLoadService.get("/commodity/center")).then(function (response) {
            $scope.centers = response.data;
        })
    };

    $scope.createCommodity = function () {
        popupOpen("#commodityModal",
            function () {
                $scope.commodity = {};
            }, function () {
                $scope.renderCommodity();
            });
    };
    $scope.editCommodity = function (item) {
        popupOpen("#commodityModal", function () {
                $scope.commodity = item;
            }, function () {
                $scope.renderCommodity();
            }
        );
    };


    $scope.deleteCommodity = function (item) {
        $q.when(DataLoadService.del("/commodity/commodity/"+item.id,"Delete the commodity?",
            $scope.renderCommodity)).then(function (response) {
        })
    };

    $scope.saveCommodity = function (commodity) {
        $q.when(DataLoadService.save("/commodity/commodity", commodity, function () {
            popupClose();
        }, swalFailure));
    };

    $scope.renderCommodity = function () {
        $q.when(DataLoadService.get("/commodity/commodity")).then(function (response) {
            $scope.commodities = response.data;
        })
    };

    $scope.renderCountry = function () {
        $q.when(DataLoadService.get("/district/country")).then(function (response) {
            $scope.countries = response.data;
            $scope.countryNames = [];
            $scope.countries.forEach(function (entry) {
                $scope.countryNames.push(entry.name);
            })
        })
    };

    $scope.init = function () {
        $scope.renderCountry();
        $scope.renderCenter();
    };

    $scope.init();

});
