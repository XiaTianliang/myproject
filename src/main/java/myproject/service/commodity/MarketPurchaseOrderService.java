package myproject.service.commodity;

import myproject.mapper.commodity.MarketPurchaseOrderMapper;
import myproject.model.commodity.MarketPurchaseOrder;
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
public class MarketPurchaseOrderService {
    @Autowired
    private MarketPurchaseOrderMapper orderMapper;

    public MarketPurchaseOrder create(MarketPurchaseOrder order)throws Exception{
        orderMapper.create(order);
        return order;
    }

    public void update(MarketPurchaseOrder order)throws Exception{
        orderMapper.update(order);
    }

    public void delete(int id)throws Exception{
        orderMapper.delete(id);
    }

    public MarketPurchaseOrder get(int id)throws Exception{
        return orderMapper.get(id);
    }

    public MarketPurchaseOrder find(int id)throws Exception{
        MarketPurchaseOrder order = get(id);
        if(order == null){
            throw new Exception("Market purchase order with id:"+id+" not found!");
        }
        return order;
    }

    public List<MarketPurchaseOrder> getAll()throws Exception{
        return orderMapper.getAll();
    }
}
