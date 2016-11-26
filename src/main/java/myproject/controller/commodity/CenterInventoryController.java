package myproject.controller.commodity;

import myproject.model.commodity.CenterInventory;
import myproject.model.commodity.Commodity;
import myproject.service.commodity.CenterInventoryService;
import myproject.service.commodity.CommodityService;
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
@RequestMapping("/commodity/centerInventory")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CenterInventoryController {
    @Autowired
    private CenterInventoryService inventoryService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody CenterInventory inventory) throws Exception {
        return ResponseEntity.ok(inventoryService.create(inventory));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody CenterInventory inventory) throws Exception {
        inventoryService.update(inventory);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(inventoryService.getAll());
    }
}
