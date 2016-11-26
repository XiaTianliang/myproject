package myproject.service.district;

import myproject.mapper.district.StateMapper;
import myproject.model.district.State;
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
public class StateService {
    @Autowired
    private StateMapper stateMapper;

    public State create(State state)throws Exception{
        stateMapper.create(state);
        return state;
    }

    public void update(State state)throws Exception{
        stateMapper.update(state);
    }

    public void delete(int stateId)throws Exception{
        stateMapper.delete(stateId);
    }

    public State get(int id)throws Exception{
        return stateMapper.get(id);
    }

    public List<State> getAll()throws Exception{
        return stateMapper.getAll();
    }

    public List<State> getByCountryId(int id)throws Exception{
        return stateMapper.getByCountryId(id);
    }

}
