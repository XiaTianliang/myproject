package myproject.intern.service;

import myproject.intern.entities.inventory.Inventory;
import myproject.intern.entities.order.PurchaseOrder;
import myproject.intern.mapper.PurchaseOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午2:40
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PurchaseService {
    @Autowired
    private PurchaseOrderMapper purchaseMapper;

    @Autowired
    private InventoryService inventoryService;


    @Transactional(rollbackFor = Exception.class)
    public PurchaseOrder create(PurchaseOrder purchaseMstDTO)throws Exception{
        if(purchaseMstDTO.getNumber() < 0){
            throw new Exception("purchase order number is less than 0");
        }
        purchaseMapper.create(purchaseMstDTO);
        //update the inventory database
        Inventory inventory = inventoryService.getBySupermarketIdAndProductId(purchaseMstDTO.getSupermarketId(),
                purchaseMstDTO.getProductId());
        if(inventory == null){
            inventory = new Inventory();
            inventory.setSupermarketId(purchaseMstDTO.getSupermarketId());
            inventory.setProductId(purchaseMstDTO.getProductId());
            inventory.setNumber(purchaseMstDTO.getNumber());
            inventoryService.create(inventory);
        }else {
            inventory.setNumber(inventory.getNumber() + purchaseMstDTO.getNumber());
            inventoryService.update(inventory);
        }
        return purchaseMstDTO;
    }

//    public void update(PurchaseOrder purchaseMstDTO)throws Exception{
//        purchaseMapper.update(purchaseMstDTO);
//    }

    public PurchaseOrder get(long id)throws Exception{
        return purchaseMapper.get(id);
    }

    public List<PurchaseOrder> getAll()throws Exception{
        return purchaseMapper.getAll();
    }

    public List<PurchaseOrder> getBySupermarketId(long supermarketId)throws Exception{
        return purchaseMapper.getBySupermarketId(supermarketId);
    }


    public List<PurchaseOrder> getBySupermarketIdAndTimePeriod(long supermarketId, Timestamp startTime,
                                                        Timestamp endTime)throws Exception{
        return purchaseMapper.getBySupermarketIdAndTimePeriod(supermarketId, startTime, endTime);
    }






}
