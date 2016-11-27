package myproject.intern.controller;

import myproject.intern.service.DataLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午2:47
 */
@RestController
@RequestMapping("/dataload")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DataLoadController {
    @Autowired
    DataLoaderService dataLoaderService;

    @RequestMapping(method = RequestMethod.GET)
    public void loadData() throws Exception {
        //dataLoaderService.readRegionTable();
        //dataLoaderService.readEmployeeTable();
        //dataLoaderService.readProductTable();
        //dataLoaderService.readSupermarketMstTable();
    }


}
