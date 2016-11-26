package myproject.controller.commodity;

import myproject.model.commodity.DistributionCenter;
import myproject.service.commodity.DistributionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午8:01
 */
@RestController
@RequestMapping("/commodity/center")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DistributionCenterController {
    @Autowired
    private DistributionCenterService distributionCenterService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody DistributionCenter center) throws Exception {
        return ResponseEntity.ok(distributionCenterService.create(center));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody DistributionCenter center) throws Exception {
        distributionCenterService.update(center);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) throws Exception {
        distributionCenterService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(distributionCenterService.getAll());
    }
}
