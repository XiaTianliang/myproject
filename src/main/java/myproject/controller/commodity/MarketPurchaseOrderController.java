package myproject.controller.commodity;

import myproject.model.commodity.MarketPurchaseOrder;
import myproject.service.commodity.MarketPurchaseOrderService;
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
@RequestMapping("/commodity/marketPurchaseOrder")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarketPurchaseOrderController {
    @Autowired
    private MarketPurchaseOrderService purchaseOrderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody MarketPurchaseOrder order) throws Exception {
        return ResponseEntity.ok(purchaseOrderService.create(order));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody MarketPurchaseOrder order) throws Exception {
        purchaseOrderService.update(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) throws Exception {
        purchaseOrderService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(purchaseOrderService.getAll());
    }

}
