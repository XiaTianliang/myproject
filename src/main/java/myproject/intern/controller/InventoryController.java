package myproject.intern.controller;

import myproject.intern.entities.inventory.Inventory;
import myproject.intern.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午8:01
 */
@RestController
@RequestMapping("/inventory")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(inventoryService.getAll());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Inventory inventory) throws Exception {
        inventoryService.update(inventory);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getBySupermarketId() throws Exception {
//        return ResponseEntity.ok(inventoryService.getAll());
//    }

//    List<Inventory> getBySupermarketId(long supermarketId)throws Exception{
//        return inventoryService.getBySupermarketId(supermarketId);
//    }

}
