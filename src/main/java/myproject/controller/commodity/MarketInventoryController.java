//package myproject.controller.commodity;
//
//import myproject.model.commodity.MarketInventory;
//import myproject.service.commodity.MarketInventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author tianliangxia
// *         Date:16-11-24
// *         Time:下午8:01
// */
//@RestController
//@RequestMapping("/commodity/marketInventory")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//public class MarketInventoryController {
//    @Autowired
//    private MarketInventoryService inventoryService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity create(@RequestBody MarketInventory inventory) throws Exception {
//        return ResponseEntity.ok(inventoryService.create(inventory));
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody MarketInventory inventory) throws Exception {
//        inventoryService.update(inventory);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getAll() throws Exception {
//        return ResponseEntity.ok(inventoryService.getAll());
//    }
//}
