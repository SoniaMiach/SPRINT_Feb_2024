package tests.e2e.positive;

import common.BasePage;
import common.TestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.VarusListsPage;
import pages.VarusProductViewPage;

import static utils.HandlesUtils.switchWindow;
import static utils.JsUtils.scrollAndRetryUntilFound;


public class SF216Test extends TestInit {
    LoginPage loginPage;
    VarusProductViewPage varusProductViewPage;
    VarusListsPage varusListsPage;

    @BeforeMethod
    public void pagesSetup() {
        loginPage = new LoginPage();
        varusProductViewPage = new VarusProductViewPage();
        varusListsPage = new VarusListsPage();


    }

    @Test
    public void sf216() {
        scrollAndRetryUntilFound(loginPage.FIRST_VARUS_CONTAINER_ITEM, 500, 1, 120);
        loginPage.saveFirstProductName().clickFirstVarusPromotialProduct();

        switchWindow(1);

        varusProductViewPage
                .checkRedirectedToProductPage()
                .clickButtonAddToFavorite()
                .assertButtonFillUp();


        varusListsPage
                .navigate()
                .checkProductPresentWithName(loginPage.productName);


    }
}

