package myproject.service.commodity;

import myproject.mapper.commodity.CenterInventoryMapper;
import myproject.mapper.commodity.MarketInventoryMapper;
import myproject.model.commodity.CenterInventory;
import myproject.model.commodity.MarketInventory;
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
public class MarketInventoryService {
    @Autowired
    private MarketInventoryMapper marketInventoryMapper;

    public MarketInventory create(MarketInventory inventory)throws Exception{
        marketInventoryMapper.create(inventory);
        return inventory;
    }

    public void update(MarketInventory inventory)throws Exception{
        marketInventoryMapper.update(inventory);
    }

    public MarketInventory get(int id)throws Exception{
        return marketInventoryMapper.get(id);
    }

    public List<MarketInventory> getAll()throws Exception{
        return marketInventoryMapper.getAll();
    }

    public MarketInventory getByMarketIdAndCommodityId(int marketId, int commodityId)throws Exception{
        return marketInventoryMapper.getByMarketIdAndCommodityId(marketId, commodityId);
    }
}
