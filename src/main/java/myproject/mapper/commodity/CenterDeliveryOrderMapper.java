package myproject.mapper.commodity;

import myproject.model.commodity.CenterDeliveryOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-25
 *         Time:上午12:13
 */
@Repository
public interface CenterDeliveryOrderMapper {
    void create(CenterDeliveryOrder order);
    void update(CenterDeliveryOrder order);
    void delete(int id);
    CenterDeliveryOrder get(@Param("id") int id);
    List<CenterDeliveryOrder> getAll();
}
