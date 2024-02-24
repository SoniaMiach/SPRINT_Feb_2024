package tests.e2e.positive;

import com.codeborne.selenide.ElementsCollection;
import common.TestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MetroProductListPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static jdk.internal.agent.Agent.getText;
import static utils.HandlesUtils.switchWindow;
import static utils.SortUtils.checkSortedLowToHigh;

public class SF28Test extends TestInit {
    LoginPage loginPage;
    MetroProductListPage metroProductListPage;

    @BeforeMethod
    public void pagesSetup() {
        loginPage = new LoginPage();
        metroProductListPage = new MetroProductListPage();
    }

    @Test
    public void sf28() {
        loginPage.clickOnSlidebarMenu().clickMetro();
        switchWindow(1);
        metroProductListPage.clickSearchInput();

        metroProductListPage.searchProductName("Молоко");

        metroProductListPage.clickSortMenuButton();

        metroProductListPage.sortLowPrice();

        sortLowToHighPrices();

        metroProductListPage.hoverToProduct();

        metroProductListPage.addToCartProduct();

        metroProductListPage.selectDeliveryType();

        metroProductListPage.saveCheapProductName();

        metroProductListPage.clickCartButton();

        checkProductInCartPage(metroProductListPage.cheapestProductTitle);


    }

    public void sortLowToHighPrices() {
        ElementsCollection prices = metroProductListPage.SORT_LOW_TO_HIGH_PRICES.shouldHave(sizeGreaterThan(29));
        softAssert.assertTrue(checkSortedLowToHigh(prices));
    }
    public void checkProductInCartPage(String expectedTitle) {
        softAssert.assertEquals(expectedTitle,metroProductListPage.NAME_OF_PRODUCT_IN_CART.text());
        }



    }

