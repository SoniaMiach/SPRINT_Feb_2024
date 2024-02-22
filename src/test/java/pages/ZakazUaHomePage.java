package pages;

import com.codeborne.selenide.SelenideElement;
import common.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ZakazUaHomePage extends BasePage {

    private static final SelenideElement LOGIN_BUTTON = $x("//span[text()='Увійти']");
    private static final SelenideElement PHONE = $x("//input[@id ='phone']");
    private static final SelenideElement PASSWORD = $x("//input[@id ='password']");
    private static final SelenideElement SUBMIT_BUTTON = $x("//button[@data-marker='Submit']");
    private static final SelenideElement LOG_BUTTON_DISPLAYED = $x("//div/span[text()='Акаунт']");
    private static final SelenideElement NOVUS_SHOP_BUTTON = $x("//a[@data-marker='NOVUS']");

    public void clickLoginButton() {
        LOGIN_BUTTON.click();
    }

    public void enterPhone(String phoneNumber) {
        PHONE.setValue(phoneNumber);
    }

    public void enterPassword(String pass) {
        PASSWORD.setValue(pass);
    }

    public void clickSubmitButton() {
        SUBMIT_BUTTON.click();
    }

    public boolean isLogButtonDisplayed() {
        return LOG_BUTTON_DISPLAYED.exists();
    }

    @Step("Go to Novus page")
    public void clickNovusShopButton() {
        NOVUS_SHOP_BUTTON.click();
    }
}
