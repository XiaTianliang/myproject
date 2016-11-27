package myproject.intern.service;

import myproject.intern.entities.region.RegionMstDTO;
import myproject.intern.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午2:40
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RegionService {
    @Autowired
    private RegionMapper regionMapper;

    public RegionMstDTO create(RegionMstDTO regionMstDTO)throws Exception{
        regionMapper.create(regionMstDTO);
        return regionMstDTO;
    }

    public void update(RegionMstDTO regionMstDTO)throws Exception{
        regionMapper.update(regionMstDTO);
    }

    public void delete(long id)throws Exception{
        regionMapper.delete(id);
    }

    public RegionMstDTO get(long id)throws Exception{
        return regionMapper.get(id);
    }

    public List<RegionMstDTO> getAll()throws Exception{
        return regionMapper.getAll();
    }
}
