package myproject.intern.mapper;

import myproject.intern.entities.supermarket.SupermarketMstDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午4:13
 */
@Repository
public interface SupermarketMstMapper {
    void create(SupermarketMstDTO supermarketMstDTO);
    void update(SupermarketMstDTO supermarketMstDTO);
    void delete(long supermarketId);
    SupermarketMstDTO get(@Param("supermarketId") long supermarketId);
    List<SupermarketMstDTO> getAll();
}
