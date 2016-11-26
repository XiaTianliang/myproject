package myproject.controller.commodity;

import myproject.model.commodity.CenterDeliveryOrder;
import myproject.model.commodity.MarketPurchaseOrder;
import myproject.model.commodity.SupplierDeliveryOrder;
import myproject.service.commodity.CenterDeliveryOrderService;
import myproject.service.commodity.SupplierDeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author tianliangxia
 *         Date:16-11-25
 *         Time:上午12:33
 */
@RestController
@RequestMapping("/commodity/centerDeliveryOrder")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CenterDeliveryOrderController {
    @Autowired
    private CenterDeliveryOrderService deliveryOrderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody CenterDeliveryOrder order) throws Exception {
        return ResponseEntity.ok(deliveryOrderService.create(order));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody CenterDeliveryOrder order) throws Exception {
        deliveryOrderService.update(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) throws Exception {
        deliveryOrderService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(deliveryOrderService.getAll());
    }

    //pass in the center purchase order id and delivery the desire goods
    @RequestMapping(value = "/{purchaseOrderId}", method = RequestMethod.POST)
    public void deliveryByPurchaseOrder(@PathVariable int purchaseOrderId) throws Exception {
        deliveryOrderService.DeliveryByPurchaseOrder(purchaseOrderId);
    }

    @RequestMapping(value = "/receive", method = RequestMethod.PUT)
    public void receiveCenterDeliveryOrder(@RequestBody CenterDeliveryOrder order) throws Exception {
        deliveryOrderService.receiveCenterDeliveryOrder(order);
    }
}
