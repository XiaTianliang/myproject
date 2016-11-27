package myproject.intern.mapper;

import myproject.intern.entities.order.SalesOrder;
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
public interface SalesOrderMapper {
    void create(SalesOrder salesOrder);
    void update(SalesOrder salesOrder);
    SalesOrder get(@Param("orderId") long orderId);
    List<SalesOrder> getAll();
    List<SalesOrder> getBySupermarketId(@Param("supermarketId") long supermarketId);
    List<SalesOrder> getBySupermarketIdAndTimePeriod(@Param("supermarketId") long supermarketId,
                                                        @Param("startTime") Timestamp startTime,
                                                        @Param("endTime") Timestamp endTime);
}
