package myproject.service.district;

import myproject.mapper.district.CityMapper;
import myproject.model.district.City;
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
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public City create(City city)throws Exception{
        cityMapper.create(city);
        return city;
    }

    public void update(City city)throws Exception{
        cityMapper.update(city);
    }

    public void delete(int stateId)throws Exception{
        cityMapper.delete(stateId);
    }

    public City get(int id)throws Exception{
        return cityMapper.get(id);
    }

    public List<City> getAll()throws Exception{
        return cityMapper.getAll();
    }

    public List<City> getByStateId(int id) throws Exception{
        return cityMapper.getByStateId(id);
    }
}
