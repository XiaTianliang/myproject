//package myproject.controller.commodity;
//
//import myproject.model.commodity.Supermarket;
//import myproject.model.commodity.Supplier;
//import myproject.service.commodity.SupermarketService;
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
//@RequestMapping("/commodity/supermarket")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//public class SupermarketController {
//    @Autowired
//    private SupermarketService supermarketService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity create(@RequestBody Supermarket supermarket) throws Exception {
//        return ResponseEntity.ok(supermarketService.create(supermarket));
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody Supermarket supermarket) throws Exception {
//        supermarketService.update(supermarket);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable int id) throws Exception {
//        supermarketService.delete(id);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getAll() throws Exception {
//        return ResponseEntity.ok(supermarketService.getAll());
//    }
//}
