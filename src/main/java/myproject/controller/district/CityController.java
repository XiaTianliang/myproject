//package myproject.controller.district;
//
//import myproject.model.district.City;
//import myproject.service.district.CityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author tianliangxia
// *         Date:16-11-24
// *         Time:下午2:47
// */
//@RestController
//@RequestMapping("/district/city")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//public class CityController {
//    @Autowired
//    private CityService cityService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity create(@RequestBody City city) throws Exception {
//        return ResponseEntity.ok(cityService.create(city));
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody City city) throws Exception {
//        cityService.update(city);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable int id) throws Exception {
//        cityService.delete(id);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getAll() throws Exception {
//        return ResponseEntity.ok(cityService.getAll());
//    }
//
//    @RequestMapping(value = "/stateId/{id}", method = RequestMethod.GET)
//    public ResponseEntity getByStateId(@PathVariable int id) throws Exception {
//        return ResponseEntity.ok(cityService.getByStateId(id));
//    }
//}
