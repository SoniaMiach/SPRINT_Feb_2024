package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import common.BasePage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class NovusShopPage extends BasePage {

    private SelenideElement seeAllCategoryButton(String categoryName) {
        return $x(format("//h2[text()='%s']/../..//span[text()='Переглянути всі']", categoryName));
    }

    private static final SelenideElement POP_CART = $x("//button[@data-marker='Close popup']");

    //@Step("Go to the category: {categoryName}")
    public void clickSeeAllCategoryButton(String categoryName) {
        seeAllCategoryButton(categoryName).shouldBe(visible).click();
    }

    public void closePopCart() {
        try {
            POP_CART.shouldBe(interactable, Duration.ofSeconds(10)).click();
        } catch (ElementNotFound e) {
            System.out.println("Exception found:" + e.getMessage());
        }
    }
}
