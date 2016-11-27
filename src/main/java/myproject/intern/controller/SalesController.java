package myproject.intern.controller;

import myproject.intern.entities.order.PurchaseOrder;
import myproject.intern.entities.order.SalesOrder;
import myproject.intern.service.PurchaseService;
import myproject.intern.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午8:01
 */
@RestController
@RequestMapping("/sales")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SalesController {
    @Autowired
    private SalesService salesService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody SalesOrder purchaseDTO) throws Exception {
        return ResponseEntity.ok(salesService.create(purchaseDTO));
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(salesService.getAll());
    }

//    List<PurchaseOrder> getBySupermarketId(long supermarketId)throws Exception{
//        return purchaseMapper.getBySupermarketId(supermarketId);
//    }
//
//
//    List<PurchaseOrder> getBySupermarketIdAndTimePeriod(long supermarketId, Timestamp startTime,
//                                                        Timestamp endTime)throws Exception{
//        return purchaseMapper.getBySupermarketIdAndTimePeriod(supermarketId, startTime, endTime);
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getBySupermarketId(@RequestParam("orderId") long orderId) throws Exception {
//        return ResponseEntity.ok(purchaseService.getBySupermarketId(orderId));
//    }

}
