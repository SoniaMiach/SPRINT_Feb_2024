package tests.e2e.positive;

import common.BasePage;
import common.TestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.open;


import static com.codeborne.selenide.Selenide.$x;
import static utils.HandlesUtils.switchWindow;
import static utils.JsUtils.scrollAndRetryUntilFound;

public class SF28Test extends TestInit {
    LoginPage loginPage;


//    @BeforeMethod
//    public void pagesSetup() {
//        loginPage = new LoginPage();
//        metroProductListPage = new MetroProductListPage();
//
//
//
//    }
//
//    @Test
//    public void sf28() {
//        loginPage.clickOnSlidebarMenu().clickMetro();
//
//
//
//        metroProductListPage
//                .searchProductName("Молоко");
//                .clickButtonOnSearchInMetro()
//                .sortIntoLowPriceProducts();
//                .selectProductAfterSort();
//
//
//        metroCart
//                .clickCartButton();
//                .checkProductInCart;
//
//    }
}
