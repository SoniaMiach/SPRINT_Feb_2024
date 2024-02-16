package tests;

import com.codeborne.selenide.Selenide;
import common.TestInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import static utils.ConfigProvider.*;

public class LoginPageTest extends TestInit {


    @BeforeMethod
    public void setup() {
    }

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