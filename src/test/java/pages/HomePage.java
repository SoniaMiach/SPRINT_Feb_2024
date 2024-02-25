package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final SelenideElement LOGIN_BUTTON = $x("//span[text()='Увійти']");
    private static final SelenideElement PHONE_FIELD = $x("//input[@id ='phone']");
    private static final SelenideElement PASSWORD_FIELD = $x("//input[@id ='password']");
    private static final SelenideElement SUBMIT_BUTTON = $x("//button[@data-marker='Submit']");
    private static final SelenideElement ACCOUNT_ICON = $x("//div/span[text()='Акаунт']");
    private static final SelenideElement ENTER_DELIVERY_ADDRESS_BUTTON = $x("//span[@class=\"css-rewdt4\"]");
    private static final SelenideElement NOVA_POSTA_BUTTON = $x("//li[text()=\"Нова пошта\"]");
    private static final SelenideElement CITY_INPUT_FIELD = $x("//input[@id=\"settlement_select\"]");
    private static final SelenideElement LUTSK_BUTTON = $x("//div[contains(@class,'SelectStyled__option')]");
    private static final SelenideElement DEPARTMENT_FIELD = $x("//div[@class=\"SelectStyled__placeholder css-1wa3eu0-placeholder\"]");
    private static final SelenideElement DEPARTMENT_BUTTON = $x("//div[text()=\"Відділення №1 (до 1100 кг): вул. Карбишева, 1 (поруч з Адреналін-Сіті)\"]");
    private static final SelenideElement CHOOSE_DEPARTMENT_BUTTON = $x("//button[@class=\"jsx-1716201709 Button Button_primarySmall\"]");
    private static final ElementsCollection STORE_ELEMENTS = $$x(" //div[@class='jsx-1810534291 FlexList__item']");
    private static final SelenideElement VACANCIES_BUTTON = $x("//*[@id='__next']/div/div/header/div[3]/div/a[1]");

    public void clickMarketIcon(String marketName) {
        specificMarketIcon(marketName).shouldBe(visible).click();
    }

    private SelenideElement specificMarketIcon(String marketName) {
        return $x(format("//a[@data-marker='%s']", marketName));
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

    public void clickEnterDeliveryAddressButton() {
        ENTER_DELIVERY_ADDRESS_BUTTON.click();
    }

    public void clickNovaPostaButton() {
        NOVA_POSTA_BUTTON.click();
    }

    public void enterCity(String city) {
        CITY_INPUT_FIELD.setValue(city);
    }

    public void clickLutskButton() {
        LUTSK_BUTTON.click();
    }

    public void clickDepartmentField() {
        DEPARTMENT_FIELD.click();
    }

    public void clickDepartmentButton() {
        DEPARTMENT_BUTTON.click();
    }

    public void clickChooseDepartmentButton() {
        CHOOSE_DEPARTMENT_BUTTON.click();
    }

    public boolean isCollectionPresentOnPage(ElementsCollection collection) {
        return collection.shouldHave(sizeGreaterThan(0)).size() >= 0;
    }

    public ElementsCollection getStoreElements() {
        return STORE_ELEMENTS;

    }

    public void clickVacanciesButton() {
        VACANCIES_BUTTON.shouldBe(visible).click();
    }

}
