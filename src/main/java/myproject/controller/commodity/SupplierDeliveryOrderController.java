//package myproject.controller.commodity;
//
//import myproject.model.commodity.SupplierDeliveryOrder;
//import myproject.service.commodity.SupplierDeliveryOrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author tianliangxia
// *         Date:16-11-25
// *         Time:上午12:33
// */
//@RestController
//@RequestMapping("/commodity/supplierDeliveryOrder")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//public class SupplierDeliveryOrderController {
//    @Autowired
//    private SupplierDeliveryOrderService deliveryOrderService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity create(@RequestBody SupplierDeliveryOrder order) throws Exception {
//        return ResponseEntity.ok(deliveryOrderService.create(order));
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody SupplierDeliveryOrder order) throws Exception {
//        deliveryOrderService.update(order);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable int id) throws Exception {
//        deliveryOrderService.delete(id);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getAll() throws Exception {
//        return ResponseEntity.ok(deliveryOrderService.getAll());
//    }
//
//    //pass in the center purchase order id and delivery the desire goods
//    @RequestMapping(value = "/{purchaseOrderId}", method = RequestMethod.POST)
//    public void deliveryByPurchaseOrder(@PathVariable int purchaseOrderId) throws Exception {
//        deliveryOrderService.DeliveryByPurchaseOrder(purchaseOrderId);
//    }
//
//    @RequestMapping(value = "/receive", method = RequestMethod.PUT)
//    public void receiveSupplierDeliveryOrder(@RequestBody SupplierDeliveryOrder order) throws Exception {
//        deliveryOrderService.receiveSupplierDeliveryOrder(order);
//    }
//}
