package myproject.controller;

import myproject.model.ClusterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import myproject.service.ClusterService;

/**
 * @author jie.huang
 *         Date: 16/8/10
 *         Time: 下午12:05
 */
@RestController
@RequestMapping("/cluster")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ClusterController {
    @Autowired
    private ClusterService clusterService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody ClusterConfig clusterConfig) throws Exception {
        return ResponseEntity.ok(clusterService.create(clusterConfig));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody ClusterConfig clusterConfig) throws Exception {
        clusterService.update(clusterConfig);
    }

    @RequestMapping(value = "/{clusterId}/deploy", method = RequestMethod.PUT)
    public void deploy(@PathVariable long clusterId) throws Exception {
        clusterService.deploy(clusterId);
    }

    @RequestMapping(value = "/{clusterId}/undeploy", method = RequestMethod.PUT)
    public void unDeploy(@PathVariable long clusterId) throws Exception {
        clusterService.unDeploy(clusterId);
    }

    @RequestMapping(value = "/{clusterId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long clusterId) throws Exception {
        clusterService.delete(clusterId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAll() throws Exception {
        return ResponseEntity.ok(clusterService.findAll());
    }

}
