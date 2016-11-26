marketPro.controller("districtController", function ($scope, $q, DataLoadService) {
    $scope.selectConfigType = function (item, key, value) {
        item[key]=value;
    };

    $scope.createCountry = function () {
        popupOpen("#countryModal",
            function () {
                $scope.country = {};
            }, function () {
                $scope.renderCountry();
            });
    };
    $scope.editCountry = function (item) {
        popupOpen("#countryModal", function () {
                $scope.country = item;
            }, function () {
                $scope.renderCountry();
            }
        );
    };

    $scope.deleteCountry = function (item) {
        $q.when(DataLoadService.del("/district/country/"+item.id,"Delete the country?",
        $scope.renderCountry)).then(function (response) {
        })
    };

    $scope.saveCountry = function (country) {
        $q.when(DataLoadService.save("/district/country", country, function () {
            popupClose();
        }, swalFailure));
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

    $scope.createState = function () {
        popupOpen("#stateModal",
            function () {
                $scope.state = {};
                $scope.state.countryNames = $scope.countryNames;
            }, function () {
                $scope.renderState();
            });
    };
    $scope.editState = function (item) {
        popupOpen("#stateModal", function () {
                $scope.state = item;
                $scope.state.countryNames = $scope.countryNames;
            }, function () {
                $scope.renderState();
            }
        );
    };

    $scope.deleteState = function (item) {
        $q.when(DataLoadService.del("/district/state/"+item.id,"Delete the state?",
            $scope.renderState)).then(function (response) {
        })
    };

    $scope.saveState = function (state) {
        //transfer countryName to id
        for(var idx in $scope.countries){
            if($scope.countries[idx]['name'] == state.countryName){
                state.countryId = $scope.countries[idx]['id'];
                break;
            }
        }
        $q.when(DataLoadService.save("/district/state", state, function () {
            popupClose();
        }, swalFailure));
    };

    $scope.renderState = function () {
        $q.when(DataLoadService.get("/district/state")).then(function (response) {
            $scope.states = response.data;
        })
    };

    $scope.createCity = function () {
        popupOpen("#cityModal",
            function () {
                $scope.city = {};
                $scope.city.countryNames = $scope.countryNames;
            }, function () {
                $scope.renderCity();
            });
    };
    $scope.editCity = function (item) {
        popupOpen("#cityModal", function () {
                $scope.city = item;
                $scope.city.countryNames = $scope.countryNames;
                $scope.getStateNamesByCountry(city);
            }, function () {
                $scope.renderCity();
            }
        );
    };

    $scope.getStateNamesByCountry = function (city) {
        //update stateNames in city according to country name
        //transfer countryName to id
        for(var idx in $scope.countries){
            if($scope.countries[idx]['name'] == city.countryName){
                city.countryId = $scope.countries[idx]['id'];
                break;
            }
        }
        $q.when(DataLoadService.get("/district/state/countryId/"+city.countryId)).then(function (response) {
            city.states = response.data;
            city.stateNames = [];
            city.states.forEach(function (entry) {
                city.stateNames.push(entry.name);
            })
        })
    };

    $scope.deleteCity = function (item) {
        $q.when(DataLoadService.del("/district/city/"+item.id,"Delete the city?",
            $scope.renderState)).then(function (response) {
        })
    };

    $scope.saveCity = function (city) {
        for(var idx in city.states){
            if(city.states[idx]['name'] == city.stateName){
                city.stateId = city.states[idx]['id'];
                break;
            }
        }
        $q.when(DataLoadService.save("/district/city", city, function () {
            popupClose();
        }, swalFailure));
    };

    $scope.renderCity = function () {
        $q.when(DataLoadService.get("/district/city")).then(function (response) {
            $scope.cities = response.data;
        })
    };

    $scope.init = function () {
        $scope.renderCountry();
        $scope.renderState();
        $scope.renderCity();
    };
    $scope.init();
});
