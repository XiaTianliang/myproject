package myproject.intern.entities.inventory.value;

import myproject.intern.entities.order.SalesOrder;
import myproject.intern.service.InventoryService;
import myproject.intern.service.SalesService;
import myproject.intern.util.SpringContextUtil;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author tianliangxia
 *         Date:16-11-29
 *         Time:上午5:04
 */
public class Value {
    private ValueType valueType;
    private String value;


    private String functionName;
    private long supermarketId;
    private long productId;




    public double getVal() throws Exception{
        if(valueType.equals(ValueType.parameter)){
            return Double.valueOf(value);
        }else {
            switch (functionName){
                case "currentInventory":
                    return  ((InventoryService)SpringContextUtil.getBean("inventoryService"))
                            .getBySupermarketIdAndProductId(supermarketId, productId).getNumber();
                case "salesLastNDays":
                    return getSalesForLastNDays(Integer.valueOf(value));
                default:
                    throw new Exception("unsupported function");
            }
        }
    }

    private long getSalesForLastNDays(int n)throws Exception{
        Timestamp end = new Timestamp(System.currentTimeMillis());
        Timestamp beg = new Timestamp(end.getTime() - n*24*3600*1000);
        List<SalesOrder> orders = ((SalesService)SpringContextUtil.getBean("salesService")).getBySupermarketIdProductIdAndTimePeriod(supermarketId, productId,
                beg, end);

        long ret = 0;
        for (SalesOrder order: orders){
            ret+=order.getNumber();
        }

        return ret;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
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
}
