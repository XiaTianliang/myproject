package myproject.intern.entities.inventory;

import myproject.intern.entities.order.SalesOrder;
import myproject.intern.service.InventoryService;
import myproject.intern.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;


/**
 * @author tianliangxia
 *         Date:16-11-28
 *         Time:下午2:34
 */
abstract public class AbstractReplenishmentModel {
    //define common variables functions

    @Autowired
    private SalesService salesService;

    @Autowired
    private InventoryService inventoryService;

    private long supermarketId;
    private long productId;
    private String productType;
    private String productName;

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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public long getSalesForLastNDays(int n)throws Exception{
        Timestamp end = new Timestamp(System.currentTimeMillis());
        Timestamp beg = new Timestamp(end.getTime() - n*24*3600*1000);
        List<SalesOrder> orders = salesService.getBySupermarketIdProductIdAndTimePeriod(supermarketId, productId,
                beg, end);

        long ret = 0;
        for (SalesOrder order: orders){
            ret+=order.getNumber();
        }

        return ret;
    }

    public long getSalesByLastDaysPeriod(int n, int m)throws Exception{
        Timestamp cur = new Timestamp(System.currentTimeMillis());
        Timestamp beg = new Timestamp(cur.getTime() - n*24*3600*1000);
        Timestamp end = new Timestamp(cur.getTime() - m*24*3600*1000);

        List<SalesOrder> orders = salesService.getBySupermarketIdProductIdAndTimePeriod(supermarketId, productId,
                beg, end);

        long ret = 0;
        for (SalesOrder order: orders){
            ret+=order.getNumber();
        }

        return ret;

    }

    public long getCurrentInvntory()throws Exception{
        return inventoryService.getBySupermarketIdAndProductId(supermarketId, productId).getNumber();
    }

    public abstract boolean check()throws Exception;
    public abstract long calculatePurchaseAmount()throws Exception;

}
