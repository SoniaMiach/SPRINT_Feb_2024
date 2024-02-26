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
    private static final String MIN_PRICE = "1000";
    private static final String MAX_PRICE = "2000";
    private static final String MARKET_NAME = "WINETIME";
    private static final String PRODUCT_CATEGORY = "ТОП 100 від Winetime";


    @Test(description = "Check price filters on WINETIME shop page")
    @Description("SF2-29")
    public void checkPriceFilters() {

        String expectedFilterRangeData = String.format("%s ₴ - %s ₴", MIN_PRICE, MAX_PRICE);

        homePage.clickMarketIcon(MARKET_NAME);
        switchTo().window(1);
        winetimeHomePage.clickDesiredCategoryButton(PRODUCT_CATEGORY);
        winetimeProductPage.enterExpectedPrices(MIN_PRICE, MAX_PRICE);
        winetimeProductPage.clickApplyPriceFilter();
        winetimeProductPage.waitLoaderDisappear();

        String filterRangeData = winetimeProductPage.getFilter();

        softAssert.assertEquals(filterRangeData, expectedFilterRangeData, "The filter range data is not as expected.");

        List<String> displayedPriceList = getListOfStrings(winetimeProductPage.getDisplayedPriceElements());

        for (String price : displayedPriceList) {
            double convertedPrice = Double.parseDouble(price);
            softAssert.assertTrue(convertedPrice >= Double.parseDouble(MIN_PRICE) && convertedPrice <= Double.parseDouble(MAX_PRICE),
                    "Price " + price + " is not within the expected range");
        }
    }
}
