package tests.e2e.positive;

import com.codeborne.selenide.WebDriverRunner;
import common.TestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VarusListsPage;
import pages.VarusProductViewPage;

import static utils.HandlesUtils.switchWindow;
import static utils.JsUtils.scrollAndRetryUntilFound;


public class WishListTest extends TestInit {
    LoginPage loginPage;
    VarusProductViewPage varusProductViewPage;
    VarusListsPage varusListsPage;

    @BeforeMethod
    public void pagesSetup() {
        loginPage = new LoginPage();
        varusProductViewPage = new VarusProductViewPage();
        varusListsPage = new VarusListsPage();
    }

    @Test(description = "This test adds Varus promotional products to favorite list")
    public void addToWishListTest() {
        scrollAndRetryUntilFound(loginPage.FIRST_VARUS_CONTAINER_ITEM, 500, 1, 120);
        loginPage.saveFirstProductName().clickFirstVarusPromotialProduct();

        switchWindow(1);
        checkRedirectedToProductPage();

        varusProductViewPage.clickButtonAddToFavorite();

        assertButtonFillUp();


        varusListsPage.navigate().checkProductPresentWithName(loginPage.productName);


    }

    public void checkRedirectedToProductPage() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedPartition = "https://varus.zakaz.ua/uk/products/";
        softAssert.assertTrue(currentUrl.startsWith(expectedPartition),"URL doesn`t start with expended partition");

    }

    public void assertButtonFillUp() {
        String buttonClass = varusProductViewPage.ADD_TO_FAVORITE_BUTTON.getAttribute("class");
        assert buttonClass != null;
        softAssert.assertTrue(buttonClass.contains("icon-heart-full"));

    }
}

