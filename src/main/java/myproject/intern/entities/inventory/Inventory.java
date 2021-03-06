package myproject.intern.entities.inventory;

/**
 * @author tianliangxia
 *         Date:16-11-27
 *         Time:上午9:33
 */
public class Inventory {
    private long inventoryId;
    private long supermarketId;
    private long productId;
    private String productName;
    private double price;
    private double salesPrice;
    private long number;
    private String modelConfig;
    private ReplenishmentModelStatus replenishmentModelStatus=ReplenishmentModelStatus.NO_MODEL;

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public long getSupermarketId() {
        return supermarketId;
    }

    public void setSupermarketId(long supermarketId) {
        this.supermarketId = supermarketId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getModelConfig() {
        return modelConfig;
    }

    public void setModelConfig(String modelConfig) {
        this.modelConfig = modelConfig;
    }

    public ReplenishmentModelStatus getReplenishmentModelStatus() {
        return replenishmentModelStatus;
    }

    public void setReplenishmentModelStatus(ReplenishmentModelStatus replenishmentModelStatus) {
        this.replenishmentModelStatus = replenishmentModelStatus;
    }
}
