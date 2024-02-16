package common;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BasePage extends TestInit{
    protected SelenideElement getVisibleOfElement(String locator) {
        return $x(locator).shouldBe(visible, Duration.ofSeconds(10));
    }

    protected SelenideElement getClickableOfElement(String locator) {
        return $x(locator).shouldBe(enabled, Duration.ofSeconds(10));
    }

    protected SelenideElement getPresenceOfElement(String locator) {
        return $x(locator).shouldBe(exist, Duration.ofSeconds(10));
    }

    protected static void scrollPageToElement(SelenideElement element) {
        String script = "arguments[0].scrollIntoView();";
        executeJavaScript(script, element);
    }
}