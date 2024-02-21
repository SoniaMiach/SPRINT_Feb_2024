package pages;

import com.codeborne.selenide.SelenideElement;
import common.TestInit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage extends TestInit {

    private static final SelenideElement CLICK_LOGIN_BUTTON = $x("//span[text()='Увійти']");
    private static final SelenideElement ENTER_PHONE = $x("//input[@id ='phone']");
    private static final SelenideElement ENTER_PASSWORD = $x("//input[@id ='password']");
    private static final SelenideElement CLICK_SUBMIT_BUTTON = $x("//button[@data-marker='Submit']");
    private static final SelenideElement IS_LOG_BUTTON_DISPLAYED = $x("//div/span[text()='Акаунт']");

    public void clickLoginButton() {CLICK_LOGIN_BUTTON.shouldBe().click();}
    public void enterPhone(String phoneNumber) {ENTER_PHONE.setValue(phoneNumber);}
    public void enterPassword(String pass) {ENTER_PASSWORD.setValue(pass);}
    public void clickSubmitButton() {CLICK_SUBMIT_BUTTON.shouldBe().click();}
    public boolean isLogButtonDisplayed() {return IS_LOG_BUTTON_DISPLAYED.shouldBe(visible).exists();}
}
