package myproject.service.commodity;

import myproject.mapper.commodity.CenterPurchaseOrderMapper;
import myproject.mapper.commodity.CommodityMapper;
import myproject.model.commodity.CenterPurchaseOrder;
import myproject.model.commodity.Commodity;
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
public class CenterPurchaseOrderService {
    @Autowired
    private CenterPurchaseOrderMapper orderMapper;

    public CenterPurchaseOrder create(CenterPurchaseOrder order)throws Exception{
        orderMapper.create(order);
        return order;
    }

    public void update(CenterPurchaseOrder order)throws Exception{
        orderMapper.update(order);
    }

    public void delete(int id)throws Exception{
        orderMapper.delete(id);
    }

    public CenterPurchaseOrder get(int id)throws Exception{
        return orderMapper.get(id);
    }

    public CenterPurchaseOrder find(int id)throws Exception{
        CenterPurchaseOrder order = get(id);
        if(order == null){
            throw new Exception("Center purchase order with id:"+id+" not found!");
        }
        return order;
    }

    public List<CenterPurchaseOrder> getAll()throws Exception{
        return orderMapper.getAll();
    }
}
