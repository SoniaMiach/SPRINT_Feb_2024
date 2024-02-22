package tests;

import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.NovusPage;
import pages.NovusProductPage;
import pages.HomePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.switchTo;
import static utils.ElementUtil.getListOfStrings;

public class NovusDiscountPricesTest extends TestInit {
    @Test(description = "Implement the price comparison for Novus store")
    @Description("SF2-23")
    public void checkDiscountPrices() {
        HomePage homePage = new HomePage();
        NovusPage novusPage = new NovusPage();
        NovusProductPage novusProductPage = new NovusProductPage();
        List<String> fullPriceList;
        List<String> discountPriceList;

        homePage.clickMarketIcon("NOVUS");
        switchTo().window(1);
        novusPage.closePopCart();
        novusPage.clickSeeAllCategoryButton("Акційні пропозиції");
        fullPriceList = getListOfStrings(novusProductPage.getFullPriceElements());
        discountPriceList = getListOfStrings(novusProductPage.getDiscountPriceElements());

        for (int i = 0; i < fullPriceList.size(); i++) {
            double fullPrice = Double.parseDouble(fullPriceList.get(i));
            double discountPrice = Double.parseDouble(discountPriceList.get(i));
            softAssert.assertTrue(fullPrice > discountPrice,
                    "Discount prise isn't lower than full price:" + fullPrice + "!>" + discountPrice);
        }
    }
}
