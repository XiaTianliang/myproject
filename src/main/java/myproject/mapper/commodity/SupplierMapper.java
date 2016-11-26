package myproject.mapper.commodity;

import myproject.model.commodity.Supplier;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午7:28
 */
@Repository
public interface SupplierMapper {
    void create(Supplier city);
    void update(Supplier city);
    void delete(int id);
    Supplier get(@Param("id") int id);
    List<Supplier> getAll();
}
