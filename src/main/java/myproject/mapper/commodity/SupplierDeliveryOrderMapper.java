package myproject.mapper.commodity;

import myproject.model.commodity.SupplierDeliveryOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-25
 *         Time:上午12:13
 */
@Repository
public interface SupplierDeliveryOrderMapper {
    void create(SupplierDeliveryOrder order);
    void update(SupplierDeliveryOrder order);
    void delete(int id);
    SupplierDeliveryOrder get(@Param("id") int id);
    List<SupplierDeliveryOrder> getAll();
}
