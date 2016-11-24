package myproject.model;

/**
 * @author yufu.deng
 *         Date: 16/8/5
 *         Time: 16:30
 */
public class ClusterConfig {
    private long id;
    private String name;
    private int containerSize;
    private Status status = Status.init;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(int containerSize) {
        this.containerSize = containerSize;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}