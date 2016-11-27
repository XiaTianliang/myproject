package myproject.intern.service;

import myproject.intern.entities.product.ProductMstDTO;
import myproject.intern.entities.product.ProductMstDtoReader;
import myproject.intern.entities.region.RegionMstDTO;
import myproject.intern.entities.region.RegionMstDTOReader;
import myproject.intern.entities.staff.StaffDTO;
import myproject.intern.entities.staff.StaffDTOReader;
import myproject.intern.entities.supermarket.SupermarketMstDTO;
import myproject.intern.entities.supermarket.SupermarketMstDTOReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-26
 *         Time:下午10:41
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DataLoaderService {
    @Autowired
    private RegionService regionService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SupermarketMstService supermarketMstService;

    public void readRegionTable() throws Exception {
        RegionMstDTOReader reader = new RegionMstDTOReader();
        List<RegionMstDTO> values = reader.getValues();
        for (RegionMstDTO value : values) {
            regionService.create(value);
        }
    }

    public void readEmployeeTable() throws Exception {
        StaffDTOReader reader = new StaffDTOReader();
        List<StaffDTO> values = reader.getValues();
        for (StaffDTO value : values) {
            staffService.create(value);
        }
    }

    public void readProductTable() throws Exception {
        ProductMstDtoReader reader = new ProductMstDtoReader();
        List<ProductMstDTO> values = reader.getValues();
        for (ProductMstDTO value : values) {
            productService.create(value);
        }
    }

    public void readSupermarketMstTable() throws Exception {
        SupermarketMstDTOReader reader = new SupermarketMstDTOReader();
        List<SupermarketMstDTO> values = reader.getValues();
        for (SupermarketMstDTO value : values) {
            supermarketMstService.create(value);
        }
    }


}
