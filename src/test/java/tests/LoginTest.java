package tests;

import com.codeborne.selenide.Selenide;
import common.TestInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ZakazUaHomePage;
import static utils.ConfigProvider.*;

public class LoginTest extends TestInit {


    @BeforeMethod
    public void setup() {
    }

    @Test
    public void loginPage() {

        ZakazUaHomePage zakazUaHomePage = new ZakazUaHomePage();

        zakazUaHomePage.clickLoginButton();
        zakazUaHomePage.enterPhone(PHONE);
        zakazUaHomePage.enterPassword(PASSWORD);
        zakazUaHomePage.clickSubmitButton();


        Assert.assertTrue(zakazUaHomePage.isLogButtonDisplayed());


    }
}