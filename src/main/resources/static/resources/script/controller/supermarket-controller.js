marketPro.controller("supermarketController", function ($scope, $q, DataLoadService) {
    $scope.selectConfigType = function (item, key, value) {
        item[key]=value;
    };

    $scope.createSupermarket = function () {
        popupOpen("#supermarketModal",
            function () {
                $scope.supermarket = {};
                $scope.supermarket.countryNames = $scope.countryNames;
            }, function () {
                $scope.renderSupermarket();
            });
    };
    $scope.editSupermarket = function (item) {
        popupOpen("#supermarketModal", function () {
                $scope.supermarket = item;
                //transfer address to countryName, stateName, cityName
                var tmp = $scope.supermarket.address.split(":");
                $scope.supermarket.countryName = tmp[0];
                $scope.supermarket.stateName = tmp[1];
                $scope.supermarket.cityName = tmp[2];
                $scope.supermarket.countryNames = $scope.countryNames;
                $scope.getStateNamesByCountry($scope.supermarket);
            }, function () {
                $scope.renderSupermarket();
            }
        );
    };

    $scope.getStateNamesByCountry = function (supermarket) {
        //update stateNames in supermarket according to country name
        for(var idx in $scope.countries){
            if($scope.countries[idx]['name'] == supermarket.countryName){
                supermarket.countryId = $scope.countries[idx]['id'];
                break;
            }
        }
        if(supermarket.countryId){
            $q.when(DataLoadService.get("/district/state/countryId/"+supermarket.countryId)).then(function (response) {
                supermarket.states = response.data;
                supermarket.stateNames = [];
                supermarket.states.forEach(function (entry) {
                    supermarket.stateNames.push(entry.name);
                })
            })
        }
    };

    $scope.getCityNamesByState = function (supermarket) {
        //update stateNames in supermarket according to country name
        for(var idx in supermarket.states){
            if(supermarket.states[idx]['name'] == supermarket.stateName){
                supermarket.stateId = supermarket.states[idx]['id'];
                break;
            }
        }
        $q.when(DataLoadService.get("/district/city/stateId/"+supermarket.stateId)).then(function (response) {
            supermarket.cities = response.data;
            supermarket.cityNames = [];
            supermarket.cities.forEach(function (entry) {
                supermarket.cityNames.push(entry.name);
            })
        })
    };

    $scope.deleteSupermarket = function (item) {
        $q.when(DataLoadService.del("/commodity/supermarket/"+item.id,"Delete the supermarket?",
            $scope.rendersupermarket)).then(function (response) {
        })
    };

    $scope.saveSupermarket = function (supermarket) {
        for(var idx in supermarket.cities){
            if(supermarket.cities[idx]['name'] == supermarket.cityName){
                supermarket.cityId = supermarket.cities[idx]['id'];
                break;
            }
        }
        $q.when(DataLoadService.save("/commodity/supermarket", supermarket, function () {
            popupClose();
        }, swalFailure));
    };

    $scope.renderSupermarket = function () {
        $q.when(DataLoadService.get("/commodity/supermarket")).then(function (response) {
            $scope.supermarkets = response.data;
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
        $scope.renderSupermarket();
    };

    $scope.init();

});
