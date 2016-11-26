package myproject.service.commodity;

import myproject.mapper.commodity.CenterDeliveryOrderMapper;
import myproject.model.commodity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午8:57
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CenterDeliveryOrderService {
    @Autowired
    private CenterDeliveryOrderMapper centerDeliveryOrderMapper;

    @Autowired
    private MarketPurchaseOrderService purchaseOrderService;

    @Autowired
    private CenterInventoryService inventoryService;

    public CenterDeliveryOrder create(CenterDeliveryOrder order)throws Exception{
        centerDeliveryOrderMapper.create(order);
        return order;
    }

    public void update(CenterDeliveryOrder order)throws Exception{
        centerDeliveryOrderMapper.update(order);
    }

    public void delete(int id)throws Exception{
        centerDeliveryOrderMapper.delete(id);
    }

    public CenterDeliveryOrder get(int id)throws Exception{
        return centerDeliveryOrderMapper.get(id);
    }

    public List<CenterDeliveryOrder> getAll()throws Exception{
        return centerDeliveryOrderMapper.getAll();
    }

    //check if the inventory is enough
    @Transactional(rollbackFor = Exception.class)
    public void DeliveryByPurchaseOrder(int purchaseOrderId)throws Exception{
        MarketPurchaseOrder purchaseOrder = purchaseOrderService.find(purchaseOrderId);
        if(purchaseOrder.getStatus().equals(PurchaseOrderStatus.wait_delivery)){
            CenterInventory inventory = inventoryService.getByCenterIdAndCommodityId(purchaseOrder.getCenterId(),
                    purchaseOrder.getCommodityId());
            if(inventory == null || inventory.getNumber() < purchaseOrder.getNumber()){
                throw new Exception("Commodity doesn't exist or not enough");
            }
            inventory.setNumber(inventory.getNumber() - purchaseOrder.getNumber());
            inventoryService.update(inventory);
            CenterDeliveryOrder order = new CenterDeliveryOrder();
            order.setPurchaseId(purchaseOrderId);
            order.setStatus(DeliveryOrderStatus.delivering);
            create(order);
            purchaseOrder.setStatus(PurchaseOrderStatus.delivering);
            purchaseOrderService.update(purchaseOrder);
        }else{
            throw new Exception("Status of purchase order with id:"+purchaseOrderId+" is not wait_delivery");
        }
    }

    //market confirm receiving the good and change the order status
    @Transactional(rollbackFor = Exception.class)
    public void receiveCenterDeliveryOrder(CenterDeliveryOrder order)throws Exception{
        if(order == null || !order.getStatus().equals(DeliveryOrderStatus.delivering)){
            throw new Exception("Status for center delivery order is wrong");
        }
        order.setStatus(DeliveryOrderStatus.received);
        centerDeliveryOrderMapper.update(order);
        MarketPurchaseOrder purchaseOrder = purchaseOrderService.find(order.getPurchaseId());
        purchaseOrder.setStatus(PurchaseOrderStatus.received);
        purchaseOrderService.update(purchaseOrder);
    }
}
