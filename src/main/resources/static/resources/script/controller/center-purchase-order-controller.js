// marketPro.controller("centerPurchaseOrderController", function ($scope, $q, DataLoadService) {
//     $scope.selectConfigType = function (item, key, value) {
//         item[key]=value;
//     };
//
//     $scope.createCenterPurchaseOrder = function () {
//         popupOpen("#centerPurchaseOrderModal",
//             function () {
//                 $scope.centerPurchaseOrder = {};
//             }, function () {
//                 $scope.renderCenterPurchaseOrder();
//             });
//     };
//     $scope.editCenterPurchaseOrder = function (item) {
//         popupOpen("#centerPurchaseOrderModal", function () {
//                 $scope.centerPurchaseOrder = item;
//             }, function () {
//                 $scope.renderCenterPurchaseOrder();
//             }
//         );
//     };
//
//     $scope.deleteCenterPurchaseOrder = function (item) {
//         $q.when(DataLoadService.del("/commodity/centerPurchaseOrder/"+item.id,"Delete the centerPurchaseOrder?",
//             $scope.renderCenterPurchaseOrder)).then(function (response) {
//         })
//     };
//
//     $scope.saveCenterPurchaseOrder = function (centerPurchaseOrder) {
//         $q.when(DataLoadService.save("/commodity/centerPurchaseOrder", centerPurchaseOrder, function () {
//             popupClose();
//         }, swalFailure));
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
//     $scope.receiveSupplierDeliveryOrder = function (item) {
//         //confirm receive supplier delivery order
//         $q.when(DataLoadService.put("/commodity/supplierDeliveryOrder/receive",item)).then(function (response) {
//             $scope.renderSupplierDeliveryOrder();
//             $scope.renderCenterPurchaseOrder();
//         })
//     };
//
//     $scope.init = function () {
//         $scope.renderCenterPurchaseOrder();
//         $scope.purchaseOrderStatus = purchaseOrderStatus;
//         $scope.renderSupplierDeliveryOrder();
//     };
//
//     $scope.init();
//
// });
