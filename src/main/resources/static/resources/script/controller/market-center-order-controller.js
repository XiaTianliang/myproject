// marketPro.controller("marketCenterOrderController", function ($scope, $q, DataLoadService) {
//     $scope.selectConfigType = function (item, key, value) {
//         item[key]=value;
//     };
//
//     $scope.createMarketPurchaseOrder = function () {
//         popupOpen("#marketPurchaseOrderModal",
//             function () {
//                 $scope.marketPurchaseOrder = {};
//             }, function () {
//                 $scope.renderMarketPurchaseOrder();
//             });
//     };
//     $scope.editMarketPurchaseOrder = function (item) {
//         popupOpen("#marketPurchaseOrderModal", function () {
//                 $scope.marketPurchaseOrder = item;
//             }, function () {
//                 $scope.renderMarketPurchaseOrder();
//             }
//         );
//     };
//
//     $scope.deleteMarketPurchaseOrder = function (item) {
//         $q.when(DataLoadService.del("/commodity/marketPurchaseOrder/"+item.id,"Delete the marketPurchaseOrder?",
//             $scope.renderMarketPurchaseOrder)).then(function (response) {
//         })
//     };
//
//     $scope.saveMarketPurchaseOrder = function (marketPurchaseOrder) {
//         $q.when(DataLoadService.save("/commodity/marketPurchaseOrder", marketPurchaseOrder, function () {
//             popupClose();
//         }, swalFailure));
//     };
//
//     $scope.renderMarketPurchaseOrder = function () {
//         $q.when(DataLoadService.get("/commodity/marketPurchaseOrder")).then(function (response) {
//             $scope.marketPurchaseOrders = response.data;
//         })
//     };
//
//     $scope.renderCenterDeliveryOrder = function () {
//         $q.when(DataLoadService.get("/commodity/centerDeliveryOrder")).then(function (response) {
//             $scope.centerDeliveryOrders = response.data;
//         })
//     };
//
//     $scope.receiveCenterDeliveryOrder = function (item) {
//         //confirm receive center delivery order
//         $q.when(DataLoadService.put("/commodity/centerDeliveryOrder/receive",item)).then(function (response) {
//             $scope.renderCenterDeliveryOrder();
//             $scope.renderMarketPurchaseOrder();
//         })
//     };
//
//     $scope.deliveryByPurchaseOrder = function (item) {
//         //handle purchase order, now only send the required good
//         $q.when(DataLoadService.post("/commodity/centerDeliveryOrder/"+item.id)).then(function (response) {
//             $scope.renderMarketPurchaseOrder();
//         })
//     };
//
//     $scope.init = function () {
//         $scope.renderMarketPurchaseOrder();
//         $scope.purchaseOrderStatus = purchaseOrderStatus;
//         $scope.renderCenterDeliveryOrder();
//     };
//
//     $scope.init();
//
// });
