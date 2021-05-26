import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class Tests {
    private Faker faker;

    @BeforeEach
    void setUpAll(){
        faker = new Faker(new Locale("ru"));
    }

    @Test
    void shouldUseFaker(){
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String cardNumber = faker.finance().creditCard(CreditCardType.MASTERCARD);
        System.out.println(name);
        System.out.println(phone);
        System.out.println(cardNumber);
    }
}
