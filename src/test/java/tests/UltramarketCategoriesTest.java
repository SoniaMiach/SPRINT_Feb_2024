package tests;

import com.codeborne.selenide.Selenide;
import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UltramarketPage;

public class UltramarketCategoriesTest extends TestInit {

    @Test(description = "Positive test - Checking the ULTRAMARKET subcategory")
    @Description("SF2-18")
    public void ultramarketSubcategoriesCheck() {
        String category = "Товари для дому";
        String subcategory = "Техніка";
        HomePage homePage = new HomePage();
        UltramarketPage ultramarketPage = new UltramarketPage();
        String productPath;

        homePage.clickMarketIcon("ULTRAMARKET");
        Selenide.switchTo().window(1);
        ultramarketPage.clickCategoryTab(category);
        ultramarketPage.clickSubcategoryButton(subcategory);
        ultramarketPage.clickFirstProduct();

        productPath = ultramarketPage.getProductPath();

        softAssert.assertTrue(productPath.contains("Головна " + category + " " + subcategory),
                "The expected path is exactly the same as the actual path. Actual: " + productPath);
    }
}