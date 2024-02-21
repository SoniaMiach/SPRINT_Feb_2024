package tests;

import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.SignInPage;

import static com.codeborne.selenide.Selenide.open;
import static utils.ConfigProvider.PASSWORD;
import static utils.ConfigProvider.PHONE;

public class SignInPageTest extends TestInit {
    SignInPage signInPage = new SignInPage();

    @Test(description = "Positive Test-Verify Login Functionality")
    @Description("SF2-26")
    public void loginPage() {

        open(BASE_URL);

        signInPage.clickLoginButton();
        signInPage.enterPhone(PHONE);
        signInPage.enterPassword(PASSWORD);
        signInPage.clickSubmitButton();

        softAssert.assertTrue(signInPage.isLogButtonDisplayed());
    }
}