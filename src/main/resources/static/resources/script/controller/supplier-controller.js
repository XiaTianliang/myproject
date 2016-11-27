// marketPro.controller("supplierController", function ($scope, $q, DataLoadService) {
//     $scope.selectConfigType = function (item, key, value) {
//         item[key]=value;
//     };
//
//     $scope.createSupplier = function () {
//         popupOpen("#supplierModal",
//             function () {
//                 $scope.supplier = {};
//                 $scope.supplier.countryNames = $scope.countryNames;
//             }, function () {
//                 $scope.renderSupplier();
//             });
//     };
//     $scope.editSupplier = function (item) {
//         popupOpen("#supplierModal", function () {
//                 $scope.supplier = item;
//                 //transfer address to countryName, stateName, cityName
//                 var tmp = $scope.supplier.address.split(":");
//                 $scope.supplier.countryName = tmp[0];
//                 $scope.supplier.stateName = tmp[1];
//                 $scope.supplier.cityName = tmp[2];
//                 $scope.supplier.countryNames = $scope.countryNames;
//                 $scope.getStateNamesByCountry($scope.supplier);
//             }, function () {
//                 $scope.renderSupplier();
//             }
//         );
//     };
//
//     $scope.getStateNamesByCountry = function (supplier) {
//         //update stateNames in supplier according to country name
//         for(var idx in $scope.countries){
//             if($scope.countries[idx]['name'] == supplier.countryName){
//                 supplier.countryId = $scope.countries[idx]['id'];
//                 break;
//             }
//         }
//         if(supplier.countryId){
//             $q.when(DataLoadService.get("/district/state/countryId/"+supplier.countryId)).then(function (response) {
//                 supplier.states = response.data;
//                 supplier.stateNames = [];
//                 supplier.states.forEach(function (entry) {
//                     supplier.stateNames.push(entry.name);
//                 })
//             })
//         }
//     };
//
//     $scope.getCityNamesByState = function (supplier) {
//         //update stateNames in supplier according to country name
//         for(var idx in supplier.states){
//             if(supplier.states[idx]['name'] == supplier.stateName){
//                 supplier.stateId = supplier.states[idx]['id'];
//                 break;
//             }
//         }
//         $q.when(DataLoadService.get("/district/city/stateId/"+supplier.stateId)).then(function (response) {
//             supplier.cities = response.data;
//             supplier.cityNames = [];
//             supplier.cities.forEach(function (entry) {
//                 supplier.cityNames.push(entry.name);
//             })
//         })
//     };
//
//     $scope.deleteSupplier = function (item) {
//         $q.when(DataLoadService.del("/commodity/supplier/"+item.id,"Delete the supplier?",
//             $scope.renderSupplier)).then(function (response) {
//         })
//     };
//
//     $scope.saveSupplier = function (supplier) {
//         for(var idx in supplier.cities){
//             if(supplier.cities[idx]['name'] == supplier.cityName){
//                 supplier.cityId = supplier.cities[idx]['id'];
//                 break;
//             }
//         }
//         $q.when(DataLoadService.save("/commodity/supplier", supplier, function () {
//             popupClose();
//         }, swalFailure));
//     };
//
//     $scope.renderSupplier = function () {
//         $q.when(DataLoadService.get("/commodity/supplier")).then(function (response) {
//             $scope.suppliers = response.data;
//         })
//     };
//
//     $scope.createCommodity = function () {
//         popupOpen("#commodityModal",
//             function () {
//                 $scope.commodity = {};
//             }, function () {
//                 $scope.renderCommodity();
//             });
//     };
//     $scope.editCommodity = function (item) {
//         popupOpen("#commodityModal", function () {
//                 $scope.commodity = item;
//             }, function () {
//                 $scope.renderCommodity();
//             }
//         );
//     };
//
//
//     $scope.deleteCommodity = function (item) {
//         $q.when(DataLoadService.del("/commodity/commodity/"+item.id,"Delete the commodity?",
//             $scope.renderCommodity)).then(function (response) {
//         })
//     };
//
//     $scope.saveCommodity = function (commodity) {
//         $q.when(DataLoadService.save("/commodity/commodity", commodity, function () {
//             popupClose();
//         }, swalFailure));
//     };
//
//     $scope.renderCommodity = function () {
//         $q.when(DataLoadService.get("/commodity/commodity")).then(function (response) {
//             $scope.commodities = response.data;
//         })
//     };
//
//     $scope.renderCountry = function () {
//         $q.when(DataLoadService.get("/district/country")).then(function (response) {
//             $scope.countries = response.data;
//             $scope.countryNames = [];
//             $scope.countries.forEach(function (entry) {
//                 $scope.countryNames.push(entry.name);
//             })
//         })
//     };
//
//     $scope.deliveryByPurchaseOrder = function (item) {
//         //handle purchase order, now only send the required good
//         $q.when(DataLoadService.post("/commodity/supplierDeliveryOrder/"+item.id)).then(function (response) {
//             $scope.renderCenterPurchaseOrder();
//         })
//     };
//
//     $scope.renderCenterPurchaseOrder = function () {
//         $q.when(DataLoadService.get("/commodity/centerPurchaseOrder")).then(function (response) {
//             $scope.centerPurchaseOrders = response.data;
//         })
//     };
//
//     $scope.renderSupplierDeliveryOrder = function () {
//         $q.when(DataLoadService.get("/commodity/supplierDeliveryOrder")).then(function (response) {
//             $scope.supplierDeliveryOrders = response.data;
//         })
//     };
//
//     $scope.init = function () {
//         $scope.renderCountry();
//         $scope.renderSupplier();
//         $scope.renderCommodity();
//         $scope.renderCenterPurchaseOrder();
//         $scope.renderSupplierDeliveryOrder();
//     };
//
//     $scope.init();
//
// });
