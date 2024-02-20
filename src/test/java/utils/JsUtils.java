package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsUtils {
    public static void scrollAndRetryUntilFound(String xpath, int pixelsToScroll, int waitTimeSeconds, int timeoutSeconds) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + timeoutSeconds * 1000L;

        while (System.currentTimeMillis() < endTime) {
            try {
                SelenideElement element = $(By.xpath(xpath));
                boolean isDisplayed = element.isDisplayed();
                if (isDisplayed) {
                    return;
                }
            } catch (Exception e) {
                // Element not found, continue scrolling
            }
            executeJavaScript("window.scrollBy(0, arguments[0]);", pixelsToScroll);
            Selenide.sleep(waitTimeSeconds * 1000L);
        }
        throw new RuntimeException("Element not found within timeout period.");
    }
}
