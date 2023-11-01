package tests.local;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class AndroidTest extends TestBase {

    @Test
    @Tag("local")
    void successfulSearchTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("local")
    void wikiOnboardingCheckTest() {
        step("Check page #1", () ->
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia")));

        step("Continue to page #2", () ->
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check page #2", () ->
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore")));

        step("Continue to page #3", () ->
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check page #3", () ->
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync")));

        step("Continue to page #4", () ->
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check page #4", () ->
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data")));


    }
}