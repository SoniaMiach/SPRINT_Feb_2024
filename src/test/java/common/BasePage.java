package common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BasePage {

    protected static void scrollPageToElement(SelenideElement element) {
        String script = "arguments[0].scrollIntoView();";
        executeJavaScript(script, element);
    }
}