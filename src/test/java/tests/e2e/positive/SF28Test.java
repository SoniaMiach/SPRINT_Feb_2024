package tests.e2e.positive;

import com.codeborne.selenide.ElementsCollection;
import common.TestInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import static utils.SortUtils.checkSortedLowToHigh;

import static com.codeborne.selenide.Selenide.*;
import static utils.HandlesUtils.switchWindow;

public class SF28Test extends TestInit {
    LoginPage loginPage;
    MetroProductListPage metroProductListPage;



    @BeforeMethod
    public void pagesSetup() {
        loginPage = new LoginPage();
        metroProductListPage = new MetroProductListPage();



    }

    @Test
    public void sf28() throws InterruptedException {
        loginPage
                .clickOnSlidebarMenu()
                .clickMetro();


        switchWindow(1);

        metroProductListPage
                .clickSearchInput()
                .searchProductName("Молоко")
                .clickSortMenuButton()
                .sortLowPrice();

        Thread.sleep(2000);
        ElementsCollection prices =$$x("//div[contains(@class, 'ProductsBox__listItem')]//span[contains(@class,'Price__value_caption')]");
        Assert.assertTrue(checkSortedLowToHigh(prices));

        metroProductListPage
                .hoverToProduct()
                .addToCartProduct()
                .selectDeliveryType()

                .saveCheapProductName()
                //запам'ятати назву на якій ти хочеш клікнути

                .clickCartButton()
                .checkProductInCartPage(metroProductListPage.cheapestProductTitle);


    }
}
