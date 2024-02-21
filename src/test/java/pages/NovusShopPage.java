package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import common.BasePage;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.*;

public class NovusShopPage extends BasePage {

    @Step("Go to the category: {categoryName}")
    public void clickSeeAllCategoryButton(String categoryName) {
        $x(format("//h2[text()='%s']/../..//span[text()='Переглянути всі']",categoryName)).click();
    }

    public void closePopCard() {
        try {
            $x("//button[@data-marker='Close popup']").shouldBe(interactable, Duration.ofSeconds(10)).click();
        } catch (ElementNotFound e){
            System.out.println("Exception found:" + e.getMessage());
        }
    }
}
