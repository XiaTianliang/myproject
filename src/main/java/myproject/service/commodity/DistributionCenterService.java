package myproject.service.commodity;

import myproject.mapper.commodity.DistributionCenterMapper;
import myproject.mapper.commodity.DistributionCenterMapper;
import myproject.model.commodity.DistributionCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午7:40
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DistributionCenterService {
    @Autowired
    private DistributionCenterMapper distributionCenterMapper;

    public DistributionCenter create(DistributionCenter distributionCenter)throws Exception{
        distributionCenterMapper.create(distributionCenter);
        return distributionCenter;
    }

    public void update(DistributionCenter distributionCenter)throws Exception{
        distributionCenterMapper.update(distributionCenter);
    }

    public void delete(int id)throws Exception{
        distributionCenterMapper.delete(id);
    }

    public DistributionCenter get(int id)throws Exception{
        return distributionCenterMapper.get(id);
    }

    public List<DistributionCenter> getAll()throws Exception{
        return distributionCenterMapper.getAll();
    }
}
