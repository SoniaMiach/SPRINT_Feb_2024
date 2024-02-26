package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class HandlesUtils {
    public static void switchWindow(int handleIndex) {
        String secondTab = WebDriverRunner.getWebDriver().getWindowHandles().toArray()[handleIndex].toString();
        Selenide.switchTo().window(secondTab);

    }
}
