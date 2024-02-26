package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import common.BasePage;
import common.TestInit;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class VarusProductViewPage extends BasePage {
    public final SelenideElement ADD_TO_FAVORITE_BUTTON = $x("(//button[@data-marker='Add product to list']/span)[1]");


    public void clickButtonAddToFavorite() {
        ADD_TO_FAVORITE_BUTTON.click();

    }

}
