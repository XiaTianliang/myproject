package myproject.controller.district;

import myproject.model.district.Country;
import myproject.service.district.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午1:16
 */
@RestController
@RequestMapping("/district/country")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CountryController {
    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Country country) throws Exception {
        return ResponseEntity.ok(countryService.create(country));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Country country) throws Exception {
        countryService.update(country);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) throws Exception {
        countryService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        return ResponseEntity.ok(countryService.getAll());
    }
}
