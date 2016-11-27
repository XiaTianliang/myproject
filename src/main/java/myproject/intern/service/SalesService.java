package myproject.intern.service;

import myproject.intern.entities.inventory.Inventory;
import myproject.intern.entities.order.PurchaseOrder;
import myproject.intern.entities.order.SalesOrder;
import myproject.intern.mapper.PurchaseOrderMapper;
import myproject.intern.mapper.SalesOrderMapper;
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
public class SalesService {
    @Autowired
    private SalesOrderMapper salesOrderMapper;

    @Autowired
    private InventoryService inventoryService;


    @Transactional(rollbackFor = Exception.class)
    public SalesOrder create(SalesOrder salesOrder)throws Exception{
        if(salesOrder.getNumber() < 0){
            throw new Exception("Sales order number is less than 0");
        }
        //update the inventory database
        Inventory inventory = inventoryService.getBySupermarketIdAndProductId(salesOrder.getSupermarketId(),
                salesOrder.getProductId());
        if(inventory == null || inventory.getNumber() < salesOrder.getNumber()){
            throw new Exception("Inventory is not enough");
        }

        inventory.setNumber(inventory.getNumber() - salesOrder.getNumber());
        inventoryService.update(inventory);
        salesOrderMapper.create(salesOrder);
        return salesOrder;
    }


    public SalesOrder get(long id)throws Exception{
        return salesOrderMapper.get(id);
    }

    public List<SalesOrder> getAll()throws Exception{
        return salesOrderMapper.getAll();
    }

    public List<SalesOrder> getBySupermarketId(long supermarketId)throws Exception{
        return salesOrderMapper.getBySupermarketId(supermarketId);
    }


    public List<SalesOrder> getBySupermarketIdAndTimePeriod(long supermarketId, Timestamp startTime,
                                                        Timestamp endTime)throws Exception{
        return salesOrderMapper.getBySupermarketIdAndTimePeriod(supermarketId, startTime, endTime);
    }
}
