package myproject.mapper.commodity;

import myproject.model.commodity.CenterPurchaseOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-25
 *         Time:上午12:13
 */
@Repository
public interface CenterPurchaseOrderMapper {
    void create(CenterPurchaseOrder order);
    void update(CenterPurchaseOrder order);
    void delete(int id);
    CenterPurchaseOrder get(@Param("id") int id);
    List<CenterPurchaseOrder> getAll();
}
