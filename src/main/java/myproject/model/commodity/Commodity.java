package myproject.model.commodity;

/**
 * @author tianliangxia
 *         Date:16-11-24
 *         Time:下午6:03
 */
public class Commodity {
    private int id;
    private int code;
    private String name;
    private int supplierId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
