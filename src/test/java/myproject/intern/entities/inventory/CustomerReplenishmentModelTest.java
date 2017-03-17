package myproject.intern.entities.inventory;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author tianliangxia
 *         Date:16-11-30
 *         Time:上午6:41
 */
public class CustomerReplenishmentModelTest {

    @Test
    public void helpTest()throws Exception{
        List<Double> nums = new ArrayList<>();
        nums.add(1.0);
        nums.add(2.0);
        nums.add(3.0);
        nums.add(4.0);
        nums.add(2.0);

        List<String> opts = new ArrayList<>();
        opts.add("+");
        opts.add("*");
        opts.add("-");
        opts.add("/");

        CustomerReplenishmentModel model = new CustomerReplenishmentModel();
        System.out.println(model.help(nums, opts));

    }

}