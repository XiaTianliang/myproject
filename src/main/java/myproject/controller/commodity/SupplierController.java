//package myproject.controller.commodity;
//
//import myproject.model.commodity.Supplier;
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
//@RequestMapping("/commodity/supplier")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//public class SupplierController{
//    @Autowired
//    private SupplierService supplierService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity create(@RequestBody Supplier supplier) throws Exception {
//        return ResponseEntity.ok(supplierService.create(supplier));
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody Supplier supplier) throws Exception {
//        supplierService.update(supplier);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable int id) throws Exception {
//        supplierService.delete(id);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getAll() throws Exception {
//        return ResponseEntity.ok(supplierService.getAll());
//    }
//}
