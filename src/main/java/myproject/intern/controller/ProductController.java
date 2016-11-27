package myproject.intern.controller;

import myproject.intern.entities.product.ProductMstDTO;
import myproject.intern.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午8:01
 */
@RestController
@RequestMapping("/product")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProductController {
    @Autowired
    private ProductService ProductMstDTOService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody ProductMstDTO productMstDTO) throws Exception {
        return ResponseEntity.ok(ProductMstDTOService.create(productMstDTO));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody ProductMstDTO productMstDTO) throws Exception {
        ProductMstDTOService.update(productMstDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) throws Exception {
        ProductMstDTOService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(ProductMstDTOService.getAll());
    }


}
