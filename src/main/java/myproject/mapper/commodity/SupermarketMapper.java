package myproject.mapper.commodity;

import myproject.model.commodity.Supermarket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午7:28
 */
@Repository
public interface SupermarketMapper {
    void create(Supermarket market);
    void update(Supermarket market);
    void delete(int id);
    Supermarket get(@Param("id") int id);
    List<Supermarket> getAll();
}
