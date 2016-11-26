package myproject.mapper.commodity;

import myproject.model.commodity.CenterInventory;
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
public interface CenterInventoryMapper {
    void create(CenterInventory inventory);
    void update(CenterInventory inventory);
    //void delete(int id);
    CenterInventory get(@Param("id") int id);
    List<CenterInventory> getAll();
    CenterInventory getByCenterIdAndCommodityId(
            @Param("centerId") int centerId,@Param("commodityId") int commodityId);
}
