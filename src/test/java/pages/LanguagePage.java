package pages;

import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LanguagePage extends BasePage {

    private static final SelenideElement CLICK_LANG_BUTTON = $x("//*[@data-marker='Responsive_desktop']");
    private static final SelenideElement SELECTED_LANGUAGE = $x("//div[contains(@class, 'textBlock')]//h1");
    private static final String ELEMENT_DROPDOWN_MENU = "//*[@data-marker='lang-menu']//*[text()='%s']";

    public void openLanguageDropdownMenu() {
        CLICK_LANG_BUTTON.click();
    }


    public String getCurrentLanguage() {
        return SELECTED_LANGUAGE.shouldBe(visible).getText();
    }

    public void selectLanguage(String languageCode) {
        CLICK_LANG_BUTTON.click();
        SelenideElement languageOption = $x(String.format(ELEMENT_DROPDOWN_MENU, languageCode)).shouldBe(visible);
        languageOption.click();
    }
}

