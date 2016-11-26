package myproject.mapper.district;

import myproject.model.district.Country;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午12:55
 */
@Repository
public interface CountryMapper {
    void create(Country country);
    void update(Country country);
    void delete(int id);
    Country get(@Param("id") int id);
    List<Country> getAll();
    //int findIdByName(@Param("name") String name);
}
