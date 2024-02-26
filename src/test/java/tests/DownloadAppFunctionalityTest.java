package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;

public class DownloadAppFunctionalityTest extends TestInit {

    @Test(description = "Positive test - Check 'Download App' Button ")
    @Description("SF2-14")
    public void downloadAppTest(){
        HomePage homePage = new HomePage();

        homePage.clickPlaymarketAppButton();
        Selenide.switchTo().window(1);

        softAssert.assertTrue(WebDriverRunner.url().contains("https://play.google.com/store/apps/details?id=ua.zakaz.android"));

        Selenide.closeWindow();
        Selenide.switchTo().window(0);
        homePage.clickAppstoreAppButton();
        Selenide.switchTo().window(1);

        softAssert.assertTrue(WebDriverRunner.url().contains("https://apps.apple.com/ua/app/zakaz-ua-grocery-delivery"));
    }
}
