package cacib.bankPayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class BankPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankPaymentApplication.class, args);
    }
}
