package pages;

import com.codeborne.selenide.Selenide;
import common.TestInit;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ZakazUaHomePage extends TestInit {

    private static final String LOGIN_BUTTON = "//span[text()='Увійти']";
    private static final String PHONE = "//input[@id ='phone']";
    private static final String PASSWORD = "//input[@id ='password']";
    private static final String SUBMIT_BUTTON = "//button[@data-marker='Submit']";
    private static final String LOG_BUTTON_DISPLAYED = "//div/span[text()='Акаунт']";
    private static final String NOVUS_SHOP_BUTTON =  "//a[@data-marker='NOVUS']";

    public void clickLoginButton() {
        $x(LOGIN_BUTTON).click();
    }

    public void enterPhone(String phoneNumber) {
        $x(PHONE).setValue(phoneNumber);
    }

    public void enterPassword(String pass) {
        $x(PASSWORD).setValue(pass);
    }

    public void clickSubmitButton() {
        $x(SUBMIT_BUTTON).click();
    }

    public boolean isLogButtonDisplayed () {
            return Selenide.$x(LOG_BUTTON_DISPLAYED).exists();
        }

        @Step("Go to Novus page")
    public void clickNovusShopButton() {
        $x(NOVUS_SHOP_BUTTON).click();
        }
    }
