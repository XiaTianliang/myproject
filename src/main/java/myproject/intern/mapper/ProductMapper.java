package myproject.intern.mapper;

import myproject.intern.entities.product.ProductMstDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午4:13
 */
@Repository
public interface ProductMapper {
    void create(ProductMstDTO ProductMstDTO);
    void update(ProductMstDTO ProductMstDTO);
    void delete(long productId);
    ProductMstDTO get(@Param("productMstId") long productMstId);
    List<ProductMstDTO> getAll();
}
