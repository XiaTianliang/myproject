package myproject.intern.service;

import myproject.intern.entities.supermarket.SupermarketMstDTO;
import myproject.intern.mapper.SupermarketMstMapper;
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
public class SupermarketMstService {
    @Autowired
    private SupermarketMstMapper supermarketMstMapper;

    public SupermarketMstDTO create(SupermarketMstDTO supermarketMstDTO)throws Exception{
        supermarketMstMapper.create(supermarketMstDTO);
        return supermarketMstDTO;
    }

    public void update(SupermarketMstDTO supermarketMstDTO)throws Exception{
        supermarketMstMapper.update(supermarketMstDTO);
    }

    public void delete(long id)throws Exception{
        supermarketMstMapper.delete(id);
    }

    public SupermarketMstDTO get(long id)throws Exception{
        return supermarketMstMapper.get(id);
    }

    public List<SupermarketMstDTO> getAll()throws Exception{
        return supermarketMstMapper.getAll();
    }
}
