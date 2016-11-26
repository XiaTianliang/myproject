package myproject.model.commodity;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午6:07
 */
public class DistributionCenter {
    private int id;
    private String name;
    private int cityId;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
