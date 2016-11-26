package myproject.service.commodity;

import myproject.mapper.commodity.CommodityMapper;
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
public class CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    public Commodity create(Commodity commodity)throws Exception{
        commodityMapper.create(commodity);
        return commodity;
    }

    public void update(Commodity commodity)throws Exception{
        commodityMapper.update(commodity);
    }

    public void delete(int id)throws Exception{
        commodityMapper.delete(id);
    }

    public Commodity get(int id)throws Exception{
        return commodityMapper.get(id);
    }

    public List<Commodity> getAll()throws Exception{
        return commodityMapper.getAll();
    }
}
