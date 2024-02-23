package pages;

import common.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CareersPage extends BasePage {

    private static final SelenideElement CONTACTS_BUTTON = $x("(//*[@id='blockId-64b4f4b97dd516000f99b88a']//li[4]/span/a[contains(text(), 'Контакти')])[1]");
    private static final SelenideElement FEEDBACK_FORM = $x("//div[@class='background_2xT' and @style='background:#f5f6f7' and @data-role='placeholder' and @data-selection-container='true']");
    private static final String INPUT_PHONE_FIELD = "(//input[@type='%s'])";
    private static final String INPUT_NAME_FIELD = "(//input[@type='text'])[1]";
    public static final String INPUT_EMAIL_FIELD = "//input[@type='email' and @id='64b4f4b97dd516000f99b880-contactForm_email']";
    public static final String INPUT_MESSAGE_FIELD = "//textarea[@id='64b4f4b97dd516000f99b880-4087ac06-b82b-4c2e-b967-80f361470a0e']";
    public static final SelenideElement SEND_BUTTON = $x("//span[@class='w-form-button__text' and text()='Надіслати']");
    public static final SelenideElement ADDITIONAL_WINDOW = $x("//section[@class='w-form-message__content']");
    public static final SelenideElement okButtonInAdditionalWindow = $x("//span[@class='w-text-content' and text()='Ok']");

    public void clickContactsButton() {
        CONTACTS_BUTTON.click();
    }

    public boolean findFeedbackForm() {
        return FEEDBACK_FORM.isDisplayed();
    }

    public CareersPage entryTextInPhoneField(String fieldName, String text) {
        SelenideElement specificField = $x(String.format(INPUT_PHONE_FIELD, fieldName));
        specificField.sendKeys(text);
        return this;
    }

    public CareersPage insertTextInNameField(String fieldName, String text) {
        SelenideElement specificField = $x(String.format(INPUT_NAME_FIELD, fieldName));
        specificField.sendKeys(text);
        return this;
    }

    public CareersPage insertTextInEmailField(String fieldName, String text) {
        SelenideElement specificField = $x(String.format(INPUT_EMAIL_FIELD, fieldName));
        specificField.sendKeys(text);
        return this;
    }

    public CareersPage insertTextInMessageField(String fieldName, String text) {
        SelenideElement specificField = $x(String.format(INPUT_MESSAGE_FIELD, fieldName));
        specificField.sendKeys(text);
        return this;
    }

    public void clickSendButton() {
        SEND_BUTTON.click();
    }

    public boolean findAdditionalWindow() {
        return ADDITIONAL_WINDOW.isDisplayed();
    }

    public void clickOkButtonInAdditionalWindow() {
        okButtonInAdditionalWindow.click();
    }
}
