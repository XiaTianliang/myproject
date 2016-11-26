package myproject.service.commodity;

import myproject.mapper.commodity.SupplierDeliveryOrderMapper;
import myproject.model.commodity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午8:57
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SupplierDeliveryOrderService {
    @Autowired
    private SupplierDeliveryOrderMapper supplierDeliveryOrderMapper;

    @Autowired
    private CenterPurchaseOrderService purchaseOrderService;

    @Autowired
    private CenterInventoryService inventoryService;

    public SupplierDeliveryOrder create(SupplierDeliveryOrder order)throws Exception{
        supplierDeliveryOrderMapper.create(order);
        return order;
    }

    public void update(SupplierDeliveryOrder order)throws Exception{
        supplierDeliveryOrderMapper.update(order);
    }

    public void delete(int id)throws Exception{
        supplierDeliveryOrderMapper.delete(id);
    }

    public SupplierDeliveryOrder get(int id)throws Exception{
        return supplierDeliveryOrderMapper.get(id);
    }

    public List<SupplierDeliveryOrder> getAll()throws Exception{
        return supplierDeliveryOrderMapper.getAll();
    }

    public void DeliveryByPurchaseOrder(int purchaseOrderId)throws Exception{
        CenterPurchaseOrder purchaseOrder = purchaseOrderService.find(purchaseOrderId);
        if(purchaseOrder.getStatus().equals(PurchaseOrderStatus.wait_delivery)){
            SupplierDeliveryOrder order = new SupplierDeliveryOrder();
            order.setPurchaseId(purchaseOrderId);
            order.setStatus(DeliveryOrderStatus.delivering);
            create(order);
            purchaseOrder.setStatus(PurchaseOrderStatus.delivering);
            purchaseOrderService.update(purchaseOrder);
        }else{
            throw new Exception("Status of purchase order with id:"+purchaseOrderId+" is not wait_delivery");
        }
    }

    //center confirm receive the good and change the order status
    //update the center inventory data
    public void receiveSupplierDeliveryOrder(SupplierDeliveryOrder order)throws Exception{
        if(order == null || !order.getStatus().equals(DeliveryOrderStatus.delivering)){
            throw new Exception("Status for supplier delivery order is wrong");
        }
        //judge if the commodity has record in center inventory, update the inventory
        CenterInventory inventory = inventoryService.getByCenterIdAndCommodityId(order.getCenterId(), order.getCommodityId());
        if(inventory == null){
            inventory = new CenterInventory();
            inventory.setCenterId(order.getCenterId());
            inventory.setCommodityId(order.getCommodityId());
            inventory.setNumber(order.getNumber());
            inventoryService.create(inventory);
        }else{
            inventory.setNumber(inventory.getNumber() + order.getNumber());
            inventoryService.update(inventory);
        }
        order.setStatus(DeliveryOrderStatus.received);
        supplierDeliveryOrderMapper.update(order);
        CenterPurchaseOrder purchaseOrder = purchaseOrderService.find(order.getPurchaseId());
        purchaseOrder.setStatus(PurchaseOrderStatus.received);
        purchaseOrderService.update(purchaseOrder);
    }
}
