package myproject.intern.entities.order;

import myproject.intern.entities.inventory.ReplenishmentModelStatus;

import java.sql.Timestamp;

/**
 * @author tianliangxia
 *         Date:16-11-27
 *         Time:上午9:31
 */
public class PurchaseOrder {
    private long orderId;
    private long supermarketId;
    private long productId;
    private String productName;
    private double price;
    private double salesPrice;
    private long number;
    private Timestamp createTime;

    private ReplenishmentModelStatus replenishmentModelStatus=ReplenishmentModelStatus.NO_MODEL;



    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public ReplenishmentModelStatus getReplenishmentModelStatus() {
        return replenishmentModelStatus;
    }

    public void setReplenishmentModelStatus(ReplenishmentModelStatus replenishmentModelStatus) {
        this.replenishmentModelStatus = replenishmentModelStatus;
    }
}
