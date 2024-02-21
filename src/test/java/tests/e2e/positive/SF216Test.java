package tests.e2e.positive;

import common.TestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.VarusListsPage;
import pages.VarusProductViewPage;

import static utils.HandlesUtils.switchWindow;
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
        scrollAndRetryUntilFound(homePage.FIRST_VARUS_CONTAINER_ITEM, 500, 1, 120);
        homePage
                .saveFirstProductName()
                .clickFirstVarusPromotialProduct();

        switchWindow(1);

        varusProductViewPage
                .checkRedirectedToProductPage()
                .clickButtonAddToFavorite()
                .assertButtonFillUp();


        varusListsPage
                .navigate()
                .checkProductPresentWithName(homePage.productName);



    }
}

