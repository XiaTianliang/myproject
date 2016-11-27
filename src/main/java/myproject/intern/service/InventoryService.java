package myproject.intern.service;

import myproject.intern.entities.inventory.Inventory;
import myproject.intern.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午2:40
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    public Inventory create(Inventory purchaseMstDTO)throws Exception{
        inventoryMapper.create(purchaseMstDTO);
        return purchaseMstDTO;
    }

    public void update(Inventory purchaseMstDTO)throws Exception{
        inventoryMapper.update(purchaseMstDTO);
    }

    public Inventory get(long id)throws Exception{
        return inventoryMapper.get(id);
    }

    public List<Inventory> getAll()throws Exception{
        return inventoryMapper.getAll();
    }

    public List<Inventory> getBySupermarketId(long supermarketId)throws Exception{
        return inventoryMapper.getBySupermarketId(supermarketId);
    }


    public Inventory getBySupermarketIdAndProductId(long supermarketId,long productId)throws Exception{
        return inventoryMapper.getBySupermarketIdAndProductId(supermarketId, productId);
    }
}
