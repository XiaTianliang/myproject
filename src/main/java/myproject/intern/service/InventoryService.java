package myproject.intern.service;

import myproject.intern.entities.inventory.Inventory;
import myproject.intern.entities.inventory.SimpleReplenishmentModel;
import myproject.intern.entities.order.PurchaseOrder;
import myproject.intern.mapper.InventoryMapper;
import myproject.intern.util.JacksonUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午2:40
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InventoryService {

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SimpleReplenishmentModel.class);
    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private PurchaseService purchaseService;

    public Inventory create(Inventory purchaseMstDTO)throws Exception{
        inventoryMapper.create(purchaseMstDTO);
        return purchaseMstDTO;
    }

    public void update(Inventory purchaseMstDTO)throws Exception{
        inventoryMapper.update(purchaseMstDTO);
        //run check!!!  simple model

        String modelConfig = purchaseMstDTO.getModelConfig();
        SimpleReplenishmentModel simpleReplenishmentModel =
                JacksonUtil.toObject(purchaseMstDTO.getModelConfig(), SimpleReplenishmentModel.class);
        long num = simpleReplenishmentModel.calculatePurchaseAmount();
        if(num > 0){
            //replenishment the good
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setSupermarketId(purchaseMstDTO.getSupermarketId());
            purchaseOrder.setProductId(purchaseMstDTO.getProductId());
            purchaseOrder.setNumber(num);
            purchaseService.create(purchaseOrder);

            LOGGER.debug("auto replenishment for order id: " + purchaseOrder.getOrderId() + " supermarket id:" + purchaseOrder.getSupermarketId()
            +" product id:" + purchaseOrder.getProductId());
        }

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
