package myproject.mapper.commodity;

import myproject.model.commodity.Commodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午8:46
 */
@Repository
public interface CommodityMapper {
    void create(Commodity city);
    void update(Commodity city);
    void delete(int id);
    Commodity get(@Param("id") int id);
    List<Commodity> getAll();
}
