package myproject.intern.entities.inventory;

import myproject.intern.entities.inventory.value.Value;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
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


    private double helphelp(double left, double right, String opts)throws Exception{
        switch (opts){
            case "+": return left+right;
            case "-": return left-right;
            case "*": return left*right;
            case "/": return left/right;
            default:throw new Exception("Unrececogied opeatores");
        }
    }

    public double help(List<Double> nums, List<String> operators)throws Exception{
        if(nums.size() == 1){
            return nums.get(0);
        }
        int idx = -1;
        for (int i=0;i<operators.size();i++){
            if (operators.get(i).equals("*") || operators.get(i).equals("/")){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            for(int i=0;i<operators.size();i++){
                if(operators.get(i).equals("+") || operators.get(i).equals("-")){
                    idx = i;
                    break;
                }
            }
        }
        double tmp = helphelp(nums.get(idx), nums.get(idx+1), operators.get(idx));
        nums.set(idx, tmp);
        nums.remove(idx + 1);
        operators.remove(idx);
        return help(nums, operators);
    }

    public String[] findOperators(String str){
        List<String> operators = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '+' || str.charAt(i) == '-' ||
                    str.charAt(i) == '*' || str.charAt(i) == '/'){
                operators.add(String.valueOf(str.charAt(i)));
            }
        }
        String[] res = new String[operators.size()];
        res = operators.toArray(res);
        return res;
    }

    private double calculateFormula(String str)throws Exception{
        LOGGER.info("str before: " + str);
        str = str.replaceAll("\\s+","");
        LOGGER.info("str after: " + str);
        String[]  numStrs= str.split("[+-/*]");
        //String[]  operators = str.split("[\\w]+");
        String[]  operators = findOperators(str);

        List<String> operatorList = new ArrayList<>();
        for (String tmp : operators){
            LOGGER.info("operator: " + tmp);
            operatorList.add(tmp);
        }
        List<Double> numList = new ArrayList<>();
        for (String tmp : numStrs){
            LOGGER.info("num: " + tmp);
            numList.add(map.get(tmp).getVal());
        }
        return help(numList, operatorList);
    }

    @Override
    public  boolean check()throws Exception{
        double res = calculateFormula(checkFormula);
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
            double tmp = calculateFormula(calculatePurchaseAmountFormula);

            res = (long)Math.ceil(tmp/map.get("batchSize").getVal()) * (long)map.get("batchSize").getVal();

        }
        LOGGER.info("calculatePurchaseAmount for supermarket id:" + getSupermarketId() + " product id:" + getProductId()
                + " size " + res);
        return res;
    }
}
