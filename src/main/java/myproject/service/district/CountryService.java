package myproject.service.district;

import myproject.mapper.district.CountryMapper;
import myproject.model.district.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午1:03
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CountryService {
    @Autowired
    private CountryMapper countryMapper;

    public Country create(Country country)throws Exception{
        countryMapper.create(country);
        return country;
    }

    public void update(Country country)throws Exception{
        countryMapper.update(country);
    }

    public void delete(int countryId)throws Exception{
        countryMapper.delete(countryId);
    }

    public Country get(int id)throws Exception{
        return countryMapper.get(id);
    }

    public List<Country> getAll()throws Exception{
        return countryMapper.getAll();
    }

}
