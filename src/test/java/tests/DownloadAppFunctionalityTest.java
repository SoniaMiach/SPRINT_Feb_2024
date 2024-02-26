package tests;

import com.codeborne.selenide.WebDriverRunner;
import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

public class DownloadAppFunctionalityTest extends TestInit {
    HomePage homePage = new HomePage();

    @Test(description = "Positive test - Check 'Download App' Button ")
    @Description("SF2-14")
    public void downloadAppTest(){
        homePage.clickMarketAppButton("Google play");
        switchTo().window(1);

        softAssert.assertTrue(url().contains("https://play.google.com/store/apps/details?id=ua.zakaz.android"));

        closeWindow();
        switchTo().window(0);
        homePage.clickMarketAppButton("App store");
        switchTo().window(1);

        softAssert.assertTrue(url().contains("https://apps.apple.com/ua/app/zakaz-ua-grocery-delivery"));
    }
}
