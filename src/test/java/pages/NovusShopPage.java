package pages;

import com.codeborne.selenide.ex.ElementNotFound;
import common.BasePage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class NovusShopPage extends BasePage {

    private static final String SEE_ALL_CATEGORY_BUTTON = "//h2[text()='%s']/../..//span[text()='Переглянути всі']";
    private static final String POP_CART = "//button[@data-marker='Close popup']";

    @Step("Go to the category: {categoryName}")
    public void clickSeeAllCategoryButton(String categoryName) {
        $x(format(SEE_ALL_CATEGORY_BUTTON, categoryName)).click();
    }

    public void closePopCart() {
        try {
            $x(POP_CART).shouldBe(interactable, Duration.ofSeconds(10)).click();
        } catch (ElementNotFound e) {
            System.out.println("Exception found:" + e.getMessage());
        }
    }
}
