package tests;

import com.codeborne.selenide.ElementsCollection;
import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.NovusProductPage;
import pages.NovusShopPage;
import pages.ZakazUaHomePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.switchTo;
import static utils.ElementUtil.getListOfStrings;

public class NovusDiscountPricesTest extends TestInit {
    @Test(description = "Implement the price comparison for Novus store")
    @Description("SF2-23")
    public void checkDiscountPrices() {
        ZakazUaHomePage zakazUaHomePage = new ZakazUaHomePage();
        NovusShopPage novusShopPage = new NovusShopPage();
        NovusProductPage novusProductPage = new NovusProductPage();
        List<String> fullPriceList;
        List<String> discountPriceList;

        zakazUaHomePage.clickNovusShopButton();
        switchTo().window(1);
        novusShopPage.closePopCart();
        novusShopPage.clickSeeAllCategoryButton("Акційні пропозиції");
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
