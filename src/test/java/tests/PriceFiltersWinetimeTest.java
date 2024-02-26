package tests;

import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WinetimeHomePage;
import pages.WinetimeProductPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.switchTo;
import static utils.ElementUtil.getListOfStrings;

public class PriceFiltersWinetimeTest extends TestInit {

    HomePage homePage = new HomePage();
    WinetimeHomePage winetimeHomePage = new WinetimeHomePage();
    WinetimeProductPage winetimeProductPage = new WinetimeProductPage();

    @Test(description = "Check price filters on WINETIME shop page")
    @Description("SF2-29")
    public void checkPriceFilters() {
        String minPrice = "1000";
        String maxPrice = "2000";
        String expectedFilterData = String.format("%s ₴ - %s ₴", minPrice, maxPrice);

        homePage.clickMarketIcon("WINETIME");
        switchTo().window(1);
        winetimeHomePage.clickDesiredCategoryButton("ТОП 100 від Winetime");
        winetimeProductPage.enterExpectedPrices(minPrice, maxPrice);
        winetimeProductPage.clickApplyPriceFilter();
        winetimeProductPage.waitLoaderDisappear();

        String filterData = winetimeProductPage.getFilter();

        softAssert.assertEquals(filterData, expectedFilterData);

        List<String> displayedPriceList = getListOfStrings(winetimeProductPage.getDisplayedPriceElements());

        for (String price : displayedPriceList) {
            double convertedPrice = Double.parseDouble(price);
            softAssert.assertTrue(convertedPrice >= Double.parseDouble(minPrice) && convertedPrice <= Double.parseDouble(maxPrice),
                    "Price " + price + " is not within the expected range");
        }
    }
}
