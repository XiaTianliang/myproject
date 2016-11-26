package myproject.mapper.commodity;


import myproject.model.commodity.DistributionCenter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午9:24
 */
@Repository
public interface DistributionCenterMapper {
    void create(DistributionCenter center);
    void update(DistributionCenter center);
    void delete(int id);
    DistributionCenter get(@Param("id") int id);
    List<DistributionCenter> getAll();
}
