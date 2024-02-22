package pages;

import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {

    private static final SelenideElement NOVUS_MARKET = $x("//a[@href='https://novus.zakaz.ua/uk/']");
    private static final SelenideElement CLICK_LOGIN_BUTTON = $x("//span[text()='Увійти']");
    private static final SelenideElement PHONE_FIELD = $x("//input[@id ='phone']");
    private static final SelenideElement PASSWORD_FIELD = $x("//input[@id ='password']");
    private static final SelenideElement SUBMIT_BUTTON = $x("//button[@data-marker='Submit']");
    private static final SelenideElement ACCOUNT_ICON = $x("//div/span[text()='Акаунт']");

    public void clickNovus() {
        NOVUS_MARKET.shouldBe(visible).click();
    }

    public void clickLoginButton() {
        CLICK_LOGIN_BUTTON.shouldBe().click();
    }

    public void enterPhone(String phoneNumber) {
        PHONE_FIELD.setValue(phoneNumber);
    }

    public void enterPassword(String pass) {
        PASSWORD_FIELD.setValue(pass);
    }

    public void clickSubmitButton() {
        SUBMIT_BUTTON.shouldBe().click();
    }

    public boolean isLogButtonDisplayed() {
        return ACCOUNT_ICON.shouldBe(visible).exists();
    }
}
