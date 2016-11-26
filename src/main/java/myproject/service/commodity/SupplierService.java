package myproject.service.commodity;

import myproject.mapper.commodity.SupplierMapper;
import myproject.model.commodity.Supplier;
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
public class SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    public Supplier create(Supplier supplier)throws Exception{
        supplierMapper.create(supplier);
        return supplier;
    }

    public void update(Supplier supplier)throws Exception{
        supplierMapper.update(supplier);
    }

    public void delete(int id)throws Exception{
        supplierMapper.delete(id);
    }

    public Supplier get(int id)throws Exception{
        return supplierMapper.get(id);
    }

    public List<Supplier> getAll()throws Exception{
        return supplierMapper.getAll();
    }
}
