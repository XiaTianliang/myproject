package myproject.intern.service;

import myproject.intern.entities.product.ProductMstDTO;
import myproject.intern.mapper.ProductMapper;
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
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public ProductMstDTO create(ProductMstDTO productMstDTO)throws Exception{
        productMapper.create(productMstDTO);
        return productMstDTO;
    }

    public void update(ProductMstDTO productMstDTO)throws Exception{
        productMapper.update(productMstDTO);
    }

    public void delete(long id)throws Exception{
        productMapper.delete(id);
    }

    public ProductMstDTO get(long id)throws Exception{
        return productMapper.get(id);
    }

    public List<ProductMstDTO> getAll()throws Exception{
        return productMapper.getAll();
    }
}
