package pages;

import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage extends BasePage {

    private SelenideElement specificMarketIcon(String marketName) {
        return $x(format("//a[@data-marker='%s']", marketName));
    }
    private static final SelenideElement LOGIN_BUTTON = $x("//span[text()='Увійти']");
    private static final SelenideElement PHONE_FIELD = $x("//input[@id ='phone']");
    private static final SelenideElement PASSWORD_FIELD = $x("//input[@id ='password']");
    private static final SelenideElement SUBMIT_BUTTON = $x("//button[@data-marker='Submit']");
    private static final SelenideElement ACCOUNT_ICON = $x("//div/span[text()='Акаунт']");

    public void clickMarketIcon(String marketName) {
        specificMarketIcon(marketName).shouldBe(visible).click();
    }

    public void clickLoginButton() {
        LOGIN_BUTTON.shouldBe().click();
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
