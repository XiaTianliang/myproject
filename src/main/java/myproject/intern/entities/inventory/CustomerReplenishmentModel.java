package myproject.intern.entities.inventory;

import myproject.intern.entities.inventory.value.Value;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author tianliangxia
 *         Date:16-11-29
 *         Time:上午4:56
 */
public class CustomerReplenishmentModel extends AbstractReplenishmentModel{

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomerReplenishmentModel.class);

    private Map<String,Value> map;

    private String checkFormula;
    private String calculatePurchaseAmountFormula;

    public Map<String, Value> getMap() {
        return map;
    }

    public void setMap(Map<String, Value> map) {
        this.map = map;
    }

    public String getCheckFormula() {
        return checkFormula;
    }

    public void setCheckFormula(String checkFormula) {
        this.checkFormula = checkFormula;
    }

    public String getCalculatePurchaseAmountFormula() {
        return calculatePurchaseAmountFormula;
    }

    public void setCalculatePurchaseAmountFormula(String calculatePurchaseAmountFormula) {
        this.calculatePurchaseAmountFormula = calculatePurchaseAmountFormula;
    }

    //analysis the formular
    //suppose that formular is simple
    //"currentInventory-safetyParameter*salesLastNDays(1)"
    @Override
    public  boolean check()throws Exception{
        String[]  strings= checkFormula.split("[\\s+-/*]");
        //need improvement
        for(String str : strings)
            LOGGER.info(str);

        double res=0;
        res = map.get(strings[0]).getVal() -
                map.get(strings[1]).getVal()*map.get(strings[2]).getVal();
        LOGGER.info("check for supermarket id:" + getSupermarketId() + " product id:" + getProductId()
                + " " + res);
        return res<0;
    }

    //just
    //"safetyInventory+salesLastNDays(1)*deliveryPeriod+onShelves-currentInventory"
    @Override
    public  long calculatePurchaseAmount()throws Exception{
        long res = 0;
        if(check()){
            String[]  strings= calculatePurchaseAmountFormula.split("[\\s+-/*]");
            //need improvement

            double tmp=0;
            tmp = map.get(strings[0]).getVal() +
                    map.get(strings[1]).getVal()*map.get(strings[2]).getVal() - map.get(strings[3]).getVal();

            res = (long)Math.ceil(tmp/map.get("batchSize").getVal()) * (long)map.get("batchSize").getVal();

        }
        LOGGER.info("calculatePurchaseAmount for supermarket id:" + getSupermarketId() + " product id:" + getProductId()
                + " size " + res);
        return res;
    }
}
