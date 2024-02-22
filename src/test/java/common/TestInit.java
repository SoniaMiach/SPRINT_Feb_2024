package common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utils.SuiteConfiguration;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;


@Listeners(listeners.TestListener.class)
public class TestInit {
    protected final String BASE_URL = "https://zakaz.ua";

    private SuiteConfiguration conf;
    protected final SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void setParam() throws IOException {
        this.conf = new SuiteConfiguration();
    }

    @Step("Preparing a browser for the test")
    @BeforeMethod
    public void setup() {
        Configuration.baseUrl = BASE_URL;
        System.setProperty("selenide.reportsFolder", "./target");
        Configuration.reportsFolder = "./target";
        Configuration.downloadsFolder = "./target";
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.browser = conf.getProperty("browser");

        clearBrowserCookies();
        open("/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
        softAssert.assertAll();
    }
}