package myproject.service;

import myproject.mapper.ClusterMapper;
import myproject.model.ClusterConfig;
import myproject.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jie.huang
 *         Date: 16/8/10
 *         Time: 下午12:06
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ClusterService {
    @Autowired
    private ClusterMapper clusterMapper;
//    @Autowired
//    private DeployService deployService;
//    @Autowired
//    private PipelineService pipelineService;

    public ClusterConfig create(ClusterConfig clusterConfig) throws Exception {
        try{
            clusterMapper.create(clusterConfig);
        }catch (DuplicateKeyException e){
            throw new Exception("Duplicate cluster config for name [" + clusterConfig.getName() + "].");
        }
        return clusterConfig;
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(ClusterConfig clusterConfig) throws Exception {
        ClusterConfig oldCluster = findById(clusterConfig.getId());

        //first save db, then sync data to zookeeper
        clusterMapper.update(clusterConfig);

        if (oldCluster.getStatus() == Status.deploy
                && oldCluster.getContainerSize() != clusterConfig.getContainerSize()) {
            //flush data to zookeeper if container size changed.
            //deployService.deployCluster(clusterConfig);
        }
    }

    public void delete(long clusterId) throws Exception {
        ClusterConfig clusterConfig = findById(clusterId);
        if (Status.deploy.equals(clusterConfig.getStatus())) {
            throw new Exception("Cluster is deployed, please un-deploy before delete it.");
        }
        clusterMapper.delete(clusterId);
    }

    public List<ClusterConfig> findAll() {
        return clusterMapper.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deploy(long clusterId) throws Exception {
        ClusterConfig clusterConfig = findById(clusterId);
        clusterConfig.setStatus(Status.deploy);
        //first update data into db,then sync data to zookeeper
        clusterMapper.update(clusterConfig);
        //deployService.deployCluster(clusterConfig);
    }

    @Transactional(rollbackFor = Exception.class)
    public void unDeploy(long clusterId) throws Exception {
//        ClusterConfig clusterConfig = findById(clusterId);
//
//        List<PipelineConfig> pipelineConfigs = pipelineService.findByClusterIdAndStatus(clusterId, Status.deploy);
//        if (pipelineConfigs != null && pipelineConfigs.size() > 0) {
//            throw new Exception("There are some deployed pipelines on this cluster, please un-deploy pipeline first.");
//        }
//        //first sync data to zookeeper, then save data into db
//        deployService.unDeployCluster(clusterConfig.getName());
//        clusterMapper.updateStatus(clusterConfig.getId(), Status.init);
    }

    public ClusterConfig findById(long clusterId) throws Exception {
        ClusterConfig cluster = clusterMapper.findById(clusterId);
        if (cluster == null) {
            throw new Exception("Cannot find related cluster.");
        }
        return cluster;
    }

}
