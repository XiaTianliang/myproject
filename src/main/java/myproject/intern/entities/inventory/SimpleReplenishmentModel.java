package myproject.intern.entities.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

/**
 * @author tianliangxia
 *         Date:16-11-28
 *         Time:下午2:38
 */
@Scope(value = "prototype")
public class SimpleReplenishmentModel extends AbstractReplenishmentModel {

    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleReplenishmentModel.class);

    private long safetyInventory;
    private long deliveryPeriod;
    private long advanceDays;
    private long batchSize;

    public long getSafetyInventory() {
        return safetyInventory;
    }

    public void setSafetyInventory(long safetyInventory) {
        this.safetyInventory = safetyInventory;
    }

    public long getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(long deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public long getAdvanceDays() {
        return advanceDays;
    }

    public void setAdvanceDays(long advanceDays) {
        this.advanceDays = advanceDays;
    }

    public long getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(long batchSize) {
        this.batchSize = batchSize;
    }

    /***
     * average = (0.1*last_fourth_weeks_sales + 0.1*last_third_week_false+
     * 0.2*last_second_weeks_sales + 0.6*last_first_weeks_sales)/7
     * @return
     */
    public double calculateDailyAverage()throws Exception{
        return (getSalesByLastDaysPeriod(28,21)*0.1 + getSalesByLastDaysPeriod(21,14)*0.1 +
                getSalesByLastDaysPeriod(14,7)*0.2 + getSalesByLastDaysPeriod(7,0)*0.6)/7;
    }


    @Override
    public boolean check()throws Exception{
        boolean res = getCurrentInventory() - safetyInventory < advanceDays*calculateDailyAverage();
        LOGGER.info("check for supermarket id:" + getSupermarketId() + " product id:" + getProductId()
        + " " + res);
        return res;
    }

    @Override
    public long calculatePurchaseAmount()throws Exception{
        long res = 0;
        if(check())
        {
            res = (long)Math.ceil(calculateDailyAverage()*(deliveryPeriod + advanceDays)/batchSize)  * batchSize;
        }
        LOGGER.info("calculatePurchaseAmount for supermarket id:" + getSupermarketId() + " product id:" + getProductId()
                + " size " + res);
        return res;
    }
}
