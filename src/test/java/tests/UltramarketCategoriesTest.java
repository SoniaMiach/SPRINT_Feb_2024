package tests;

import com.codeborne.selenide.Selenide;
import common.TestInit;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UltramarketShopPage;

public class UltramarketCategoriesTest extends TestInit {

    @Test
    public void UltramarketSubcategoriesCheck() {

        String category = "Товари для дому";
        String subcategory = "Техніка";
        LoginPage loginPage = new LoginPage();
        UltramarketShopPage ultramarketPage = new UltramarketShopPage();
        String productPath;

        loginPage.clickUltramarketButton();
        Selenide.switchTo().window(1);
        ultramarketPage.clickCategoryTab(category);
        ultramarketPage.clickSubcategoryButton(subcategory);
        ultramarketPage.clickFirstProduct();

        productPath = ultramarketPage.getProductPath();

        softAssert.assertTrue(productPath.contains("Головна "+ category + " " + subcategory));
    }
}