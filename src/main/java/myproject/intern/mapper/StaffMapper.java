package myproject.intern.mapper;

import myproject.intern.entities.region.RegionMstDTO;
import myproject.intern.entities.staff.StaffDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午4:13
 */
@Repository
public interface StaffMapper {
    void create(StaffDTO staffDTO);
    void update(StaffDTO staffDTO);
    void delete(long staffId);
    StaffDTO get(@Param("staffId") long staffId);
    List<StaffDTO> getAll();
}
