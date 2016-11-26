package myproject.mapper.commodity;

import myproject.model.commodity.MarketInventory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午8:46
 */
@Repository
public interface MarketInventoryMapper {
    void create(MarketInventory inventory);
    void update(MarketInventory inventory);
    MarketInventory get(@Param("id") int id);
    List<MarketInventory> getAll();
    MarketInventory getByMarketIdAndCommodityId(
            @Param("marketId") int centerId, @Param("commodityId") int commodityId);
}
