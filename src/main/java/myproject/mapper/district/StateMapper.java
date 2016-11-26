package myproject.mapper.district;

import myproject.model.district.State;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午2:40
 */
@Repository
public interface StateMapper {
    void create(State state);
    void update(State state);
    void delete(int id);
    State get(@Param("id") int id);
    List<State> getAll();
    List<State> getByCountryId(@Param("id") int id);
}
