package tests;

import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NovusPage;

import static com.codeborne.selenide.Selenide.switchTo;

public class ChangeRegionInTheStoreTest extends TestInit {

    HomePage homePage = new HomePage();
    NovusPage novusPage = new NovusPage();

    @DataProvider(name = "expectedRegionTexts")
    public Object[][] provideExpectedRegionTexts() {
        return new Object[][]{
                {"Київ"},
                {"Рівне"},
        };
    }

    @Test(description = "Change the region in the store", dataProvider = "expectedRegionTexts")
    @Description("SF2-25")
    public void changeRegion(String expectedSubstring) {
        homePage.clickMarketIcon("NOVUS");
        switchTo().window(1);
        novusPage.closePopCart();
        novusPage.clickChangeRegionButton();
        novusPage.clickSelfPickupButton();
        novusPage.insertRegionField(expectedSubstring);

        String regionText = novusPage.getTextRegion();

        softAssert.assertTrue(regionText.contains(expectedSubstring), "The text does not match " + expectedSubstring);
    }
}