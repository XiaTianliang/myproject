package myproject.service.commodity;

import myproject.mapper.commodity.SupermarketMapper;
import myproject.model.commodity.Supermarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午7:40
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SupermarketService {
    @Autowired
    private SupermarketMapper supermarketMapper;

    public Supermarket create(Supermarket supermarket)throws Exception{
        supermarketMapper.create(supermarket);
        return supermarket;
    }

    public void update(Supermarket supermarket)throws Exception{
        supermarketMapper.update(supermarket);
    }

    public void delete(int id)throws Exception{
        supermarketMapper.delete(id);
    }

    public Supermarket get(int id)throws Exception{
        return supermarketMapper.get(id);
    }

    public List<Supermarket> getAll()throws Exception{
        return supermarketMapper.getAll();
    }
}
