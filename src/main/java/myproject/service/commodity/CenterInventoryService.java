package myproject.service.commodity;

import myproject.mapper.commodity.CenterInventoryMapper;
import myproject.mapper.commodity.CommodityMapper;
import myproject.model.commodity.CenterInventory;
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
public class CenterInventoryService {
    @Autowired
    private CenterInventoryMapper centerInventoryMapper;

    public CenterInventory create(CenterInventory inventory)throws Exception{
        centerInventoryMapper.create(inventory);
        return inventory;
    }

    public void update(CenterInventory inventory)throws Exception{
        centerInventoryMapper.update(inventory);
    }

    public CenterInventory get(int id)throws Exception{
        return centerInventoryMapper.get(id);
    }

    public List<CenterInventory> getAll()throws Exception{
        return centerInventoryMapper.getAll();
    }

    public CenterInventory getByCenterIdAndCommodityId(int centerId, int commodityId)throws Exception{
        return centerInventoryMapper.getByCenterIdAndCommodityId(centerId, commodityId);
    }
}
