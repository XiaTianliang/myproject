package myproject.mapper;

import myproject.model.ClusterConfig;
import myproject.model.Status;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jie.huang
 *         Date: 16/8/10
 *         Time: 下午12:06
 */
@Repository
public interface ClusterMapper {
    void create(ClusterConfig clusterConfig);

    void update(ClusterConfig clusterConfig);

    void updateStatus(@Param("id") long id, @Param("status") Status status);

    void delete(long id);

    List<ClusterConfig> findAll();

    ClusterConfig findById(long id);

}
