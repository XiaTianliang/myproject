package myproject.intern.mapper;

import myproject.intern.entities.inventory.Inventory;
import myproject.intern.entities.order.SalesOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午4:13
 */
@Repository
public interface InventoryMapper {
    void create(Inventory inventory);
    void update(Inventory inventory);
    Inventory get(@Param("inventoryId") long inventoryId);
    List<Inventory> getAll();
    List<Inventory> getBySupermarketId(@Param("supermarketId") long supermarketId);
    Inventory getBySupermarketIdAndProductId(@Param("supermarketId") long supermarketId,
                                             @Param("productId") long productId);
}
