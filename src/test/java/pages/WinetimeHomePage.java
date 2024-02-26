package pages;

import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class WinetimeHomePage extends BasePage {
    private SelenideElement allCategoriesButton(String productCategory) {
        return $x(format("//li[@title='%s']", productCategory));
    }

    public void clickDesiredCategoryButton(String productCategory) {
        allCategoriesButton(productCategory).shouldBe(visible).click();
    }
}

