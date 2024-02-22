package tests;

import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;

import static utils.ConfigProvider.PASSWORD;
import static utils.ConfigProvider.PHONE;

public class SignInTest extends TestInit {
    HomePage signInPage = new HomePage();

    @Test(description = "Positive Test-Verify Login Functionality")
    @Description("SF2-26")
    public void loginPage() {

        signInPage.clickLoginButton();
        signInPage.enterPhone(PHONE);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickSubmitButton();

        softAssert.assertTrue(signInPage.isLogButtonDisplayed());
    }
}