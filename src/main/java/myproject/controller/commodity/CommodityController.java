//package myproject.controller.commodity;
//
//import myproject.model.commodity.Commodity;
//import myproject.model.commodity.Supplier;
//import myproject.service.commodity.CommodityService;
//import myproject.service.commodity.SupplierService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author tianliangxia
// *         Date:16-11-24
// *         Time:下午8:01
// */
//@RestController
//@RequestMapping("/commodity/commodity")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//public class CommodityController {
//    @Autowired
//    private CommodityService commodityService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity create(@RequestBody Commodity commodity) throws Exception {
//        return ResponseEntity.ok(commodityService.create(commodity));
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody Commodity commodity) throws Exception {
//        commodityService.update(commodity);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable int id) throws Exception {
//        commodityService.delete(id);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getAll() throws Exception {
//        return ResponseEntity.ok(commodityService.getAll());
//    }
//}
