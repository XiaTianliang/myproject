package myproject.controller.district;

import myproject.model.district.State;
import myproject.service.district.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午2:47
 */
@RestController
@RequestMapping("/district/state")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StateController {
    @Autowired
    private StateService stateService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody State state) throws Exception {
        return ResponseEntity.ok(stateService.create(state));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody State state) throws Exception {
        stateService.update(state);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) throws Exception {
        stateService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(stateService.getAll());
    }

    @RequestMapping(value = "/countryId/{id}", method = RequestMethod.GET)
    public ResponseEntity getByCountryId(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(stateService.getByCountryId(id));
    }

}
