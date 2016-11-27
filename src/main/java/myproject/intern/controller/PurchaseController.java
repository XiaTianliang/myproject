package myproject.intern.controller;

import myproject.intern.entities.order.PurchaseOrder;
import myproject.intern.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午8:01
 */
@RestController
@RequestMapping("/purchase")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody PurchaseOrder purchaseDTO) throws Exception {
        return ResponseEntity.ok(purchaseService.create(purchaseDTO));
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(purchaseService.getAll());
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
