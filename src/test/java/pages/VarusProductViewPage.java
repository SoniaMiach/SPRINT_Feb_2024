package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import common.TestInit;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class VarusProductViewPage extends TestInit {
    public final String ADD_TO_FAVORITE_BUTTON= "(//button[@data-marker='Add product to list']/span)[1]";


    public VarusProductViewPage clickButtonAddToFavorite() {
        $(By.xpath(ADD_TO_FAVORITE_BUTTON)).click();
        return this;
    }

    public VarusProductViewPage checkRedirectedToProductPage() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedPartition = "https://varus.zakaz.ua/uk/products/";
        Assert.assertTrue("URL doesn`t start with expended partition", currentUrl.startsWith(expectedPartition));
        return this;
    }

    public void assertButtonFillUp() {
        SelenideElement saveToProductsListButton = $(By.xpath(ADD_TO_FAVORITE_BUTTON));
        String buttonClass = saveToProductsListButton.getAttribute("class");
        assert buttonClass != null;
        Assert.assertTrue(buttonClass.contains("icon-heart-full"));

    }
}
