package tests;

import com.codeborne.selenide.Selenide;
import common.TestInit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static utils.ConfigProvider.PASSWORD;
import static utils.ConfigProvider.PHONE;

public class LoginPageTest extends TestInit {
    @Test
    public void loginPage() {

        LoginPage loginPage = new LoginPage();

        Selenide.open(BASE_URL);
        loginPage.clickLoginButton();
        loginPage.enterPhone(PHONE);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickSubmitButton();

        Assert.assertTrue(loginPage.isLogButtonDisplayed());

    }
}