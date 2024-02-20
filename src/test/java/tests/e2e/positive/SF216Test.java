package tests.e2e.positive;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import common.TestInit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.VarusListsPage;
import pages.VarusProductViewPage;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.JsUtils.scrollAndRetryUntilFound;


public class SF216Test extends TestInit {
    HomePage homePage;
    VarusProductViewPage varusProductViewPage;
    VarusListsPage varusListsPage;

    @BeforeMethod
    public void pagesSetup() {
        homePage = new HomePage();
        varusProductViewPage = new VarusProductViewPage();
        varusListsPage = new VarusListsPage();


    }

    @Test
    public void sf216() {
        scrollAndRetryUntilFound("(//img[@alt='varus']/ancestor::div[1]/ancestor::div[1]/following-sibling::div[1]//div[contains(@class,'Slider__item')])[1]", 500, 1, 120);

        SelenideElement firstProductFromVarusPromotionList = $(By.xpath("(//img[@alt='varus']/ancestor::div[1]/ancestor::div[1]/following-sibling::div[1]//div[contains(@class,'Slider__item')])[1]"));
        String productName = firstProductFromVarusPromotionList.findAll(byTagName("h3")).first().text();
        homePage.clickFirstVarusPromotialProduct();
        String secondTab = WebDriverRunner.getWebDriver().getWindowHandles().toArray()[1].toString();
        Selenide.switchTo().window(secondTab);

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedPartition = "https://varus.zakaz.ua/uk/products/";
        Assert.assertTrue("URL doesn`t start with expended partition", currentUrl.startsWith(expectedPartition));

        varusProductViewPage.clickButtonAddToFavorite();
        SelenideElement saveToProductsListButton = $(By.xpath("(//button[@data-marker='Add product to list']/span)[1]"));
        String buttonClass = saveToProductsListButton.getAttribute("class");
        assert buttonClass != null;
        Assert.assertTrue(buttonClass.contains("icon-heart-full"));

        varusListsPage.navigate();
        SelenideElement title = $$(By.xpath("//div[contains(@class, 'ProductsBox__listItem')]/descendant::span[@data-testid='product_tile_title']")).first();
        String text = title.getText();
        Assert.assertEquals(text, productName);

    }
}

