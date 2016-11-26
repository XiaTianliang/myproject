package myproject.mapper.district;

import myproject.model.district.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午4:13
 */
@Repository
public interface CityMapper {
    void create(City city);
    void update(City city);
    void delete(int id);
    City get(@Param("id") int id);
    List<City> getAll();
    List<City> getByStateId(@Param("id") int id);
}
