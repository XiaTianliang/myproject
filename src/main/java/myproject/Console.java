package myproject;

/**
 * @author tianliangxia
 *         Date:16-11-14
 *         Time:下午10:44
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("myproject")
public class Console implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Console.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //nothing do
        //noly to load the da


    }
}