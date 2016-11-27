package myproject.intern.mapper;

import myproject.intern.entities.region.RegionMstDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午4:13
 */
@Repository
public interface RegionMapper {
    void create(RegionMstDTO regionMstDTO);
    void update(RegionMstDTO regionMstDTO);
    void delete(long regionId);
    RegionMstDTO get(@Param("regionId") long regionId);
    List<RegionMstDTO> getAll();
}
