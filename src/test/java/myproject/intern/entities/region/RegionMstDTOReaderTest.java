package myproject.intern.entities.region;

import myproject.intern.mapper.RegionMapper;
import myproject.intern.service.RegionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author tianliangxia
 *         Date:16-11-26
 *         Time:下午10:08
 */
public class RegionMstDTOReaderTest {

    @Test
    public void readRegionTable() throws Exception {
        RegionMstDTOReader reader = new RegionMstDTOReader();
        List<RegionMstDTO> values = reader.getValues();
        assertNotNull(values);
        for (RegionMstDTO value : values) {
            assertNotNull(value);
            assertNotNull(value.getManagerId());
            assertNotNull(value.getName());
            assertNotNull(value.getRegionId());
        }
    }
}