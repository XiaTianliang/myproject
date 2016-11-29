package myproject.intern.service;

import myproject.intern.entities.inventory.CustomerReplenishmentModel;
import myproject.intern.entities.inventory.Inventory;
import myproject.intern.entities.inventory.ReplenishmentModelStatus;
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

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午2:40
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InventoryService {

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InventoryService.class);
    @Autowired
    private InventoryMapper inventoryMapper;


    @Autowired
    private PurchaseService purchaseService;

    public Inventory create(Inventory inventory)throws Exception{
        inventoryMapper.create(inventory);
        return inventory;
    }

    public void update(Inventory inventory)throws Exception{
        inventoryMapper.update(inventory);
    }

    //run check!!!  simple model
    //can't place in the update() function
    public void replenishment(long supermarketId, long productId)throws Exception{
        Inventory inventory = getBySupermarketIdAndProductId(supermarketId, productId);
        String modelConfig = inventory.getModelConfig();
        if(modelConfig != null){
            long num=0;
            switch (inventory.getReplenishmentModelStatus()){
                case SIMPLE_MODEL:
                    SimpleReplenishmentModel simpleReplenishmentModel =
                            JacksonUtil.toObject(inventory.getModelConfig(), SimpleReplenishmentModel.class);
                    num = simpleReplenishmentModel.calculatePurchaseAmount();
                    break;
                case CUSTOMIZED_MODEL:
                    CustomerReplenishmentModel model = JacksonUtil.toObject(inventory.getModelConfig(), CustomerReplenishmentModel.class);
                    num = model.calculatePurchaseAmount();
                case NO_MODEL:

            }
            if(num > 0){
                //replenishment the good
                PurchaseOrder purchaseOrder = new PurchaseOrder();
                purchaseOrder.setSupermarketId(inventory.getSupermarketId());
                purchaseOrder.setProductId(inventory.getProductId());
                purchaseOrder.setNumber(num);
                purchaseOrder.setReplenishmentModelStatus(inventory.getReplenishmentModelStatus());
                purchaseService.create(purchaseOrder);

                LOGGER.info("auto replenishment for supermarket id:" + purchaseOrder.getSupermarketId()
                        +" product id:" + purchaseOrder.getProductId() + " number: " + purchaseOrder.getNumber()
                + "with " + inventory.getReplenishmentModelStatus());
            }
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
