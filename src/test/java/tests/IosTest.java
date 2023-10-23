package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

public class IosTest extends TestBase {

    @Test
    @Tag("ios")
    void findHelloTextTest() {
        step("Input hello@browserstack.com", () -> {
            $(id("Text Button")).click();
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys("hello@browserstack.com" + "\n");
        });
        step("Check hello@browserstack.com", () -> {
            assertThat($(id("Text Output")).getText())
                    .isEqualTo("hello@browserstack.com");
        });
    }
}