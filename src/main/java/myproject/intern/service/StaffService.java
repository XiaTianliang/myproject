package myproject.intern.service;

import myproject.intern.entities.staff.StaffDTO;
import myproject.intern.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午2:40
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StaffService {
    @Autowired
    private StaffMapper staffMapper;

    public StaffDTO create(StaffDTO staffMstDTO)throws Exception{
        staffMapper.create(staffMstDTO);
        return staffMstDTO;
    }

    public void update(StaffDTO staffMstDTO)throws Exception{
        staffMapper.update(staffMstDTO);
    }

    public void delete(long id)throws Exception{
        staffMapper.delete(id);
    }

    public StaffDTO get(long id)throws Exception{
        return staffMapper.get(id);
    }

    public List<StaffDTO> getAll()throws Exception{
        return staffMapper.getAll();
    }
}
