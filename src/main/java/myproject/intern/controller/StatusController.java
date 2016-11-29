package myproject.intern.controller;

import myproject.intern.entities.inventory.ReplenishmentModelStatus;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianliangxia
 *         Date:16-11-30
 *         Time:上午12:07
 */
@RestController
@RequestMapping("/status")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StatusController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception {
        Map<String, Object> status = new HashMap<>();
        status.put("replenishmentModelStatus", ReplenishmentModelStatus.values());
        return ResponseEntity.ok(status);
    }


}
