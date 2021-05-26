import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    private final Faker faker = new Faker(new Locale("ru"));

    public String generateCity() {
        return faker.address().cityName();
    }

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public String generatePhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String generateName() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }
}
