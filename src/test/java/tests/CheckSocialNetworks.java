package tests;

import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;


public class CheckSocialNetworks extends TestInit {

    HomePage homePage = new HomePage();
    @Test(description = "Check social networks")
    @Description("SF2-21")
    public void checkSocialNetworks() {

        homePage.clickFacebookLogo();
        switchTo().window(1);
        softAssert.assertTrue(url().contains("facebook.com/Zakaz.ua"));

        closeWindow();
        switchTo().window(0);
        homePage.clickInstagramLogo();
        switchTo().window(1);
        softAssert.assertTrue(url().contains("instagram.com/zakaz.ua/"));

        closeWindow();
        switchTo().window(0);
        homePage.clickLinkedInLogo();
        switchTo().window(1);
        softAssert.assertTrue(url().contains("linkedin.com/company/zakaz-ua/"));

        closeWindow();
        switchTo().window(0);
        homePage.clickTikTokLogo();
        switchTo().window(1);
        softAssert.assertTrue(url().contains("tiktok.com/@zakaz.ua"));
    }
}
