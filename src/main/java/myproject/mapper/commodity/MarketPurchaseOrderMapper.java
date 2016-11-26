package myproject.mapper.commodity;

import myproject.model.commodity.MarketPurchaseOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-25
 *         Time:上午12:13
 */
@Repository
public interface MarketPurchaseOrderMapper {
    void create(MarketPurchaseOrder order);
    void update(MarketPurchaseOrder order);
    void delete(int id);
    MarketPurchaseOrder get(@Param("id") int id);
    List<MarketPurchaseOrder> getAll();
}
