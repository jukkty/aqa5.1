import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Tests {
    private final DataGenerator dataGenerator = new DataGenerator();

    @BeforeEach
    void setUp(){
        open("http://localhost:7777");
    }

    @Test
    void shouldPass() throws InterruptedException {
        $("[placeholder='Город']").sendKeys(dataGenerator.generateCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(dataGenerator.generateDate(3));
        $("[name='name']").sendKeys(dataGenerator.generateName());
        $("[name='phone']").sendKeys(dataGenerator.generatePhone());
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Запланировать")).click();
        $(".notification__content").shouldHave(exactText("Встреча успешно запланирована на " + dataGenerator.generateDate(3)));
        Thread.sleep(5000);
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(dataGenerator.generateDate(4));
        $$("button").find(exactText("Запланировать")).click();
        $$(".button__text").find(exactText("Перепланировать")).click();
        $(".notification__content").shouldHave(exactText("Встреча успешно запланирована на " + dataGenerator.generateDate(4)));

    }
}
