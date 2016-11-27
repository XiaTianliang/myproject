package myproject.intern.mapper;

import myproject.intern.entities.order.PurchaseOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午4:13
 */
@Repository
public interface PurchaseOrderMapper {
    void create(PurchaseOrder purchaseOrder);
    void update(PurchaseOrder purchaseOrder);
    PurchaseOrder get(@Param("orderId") long orderId);
    List<PurchaseOrder> getAll();
    List<PurchaseOrder> getBySupermarketId(@Param("supermarketId") long supermarketId);
    List<PurchaseOrder> getBySupermarketIdAndTimePeriod(@Param("supermarketId") long supermarketId,
                                                        @Param("startTime") Timestamp startTime,
                                                        @Param("endTime") Timestamp endTime);
}
