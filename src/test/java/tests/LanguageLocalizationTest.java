package tests;

import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LanguagePage;

public class LanguageLocalizationTest extends TestInit {

    @DataProvider(name = "LanguageLocalizationTest")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"Укр", "Сервіс доставки продуктів із гіпермаркетів"},
                {"Рус", "Сервис доставки продуктов из гипермаркетов"},
                {"Eng", "Delivery service of products from hypermarkets"}
        };
    }

    @Test(dataProvider = "LanguageLocalizationTest")
    @Description("SF2-15")
    public void verifyLanguageAndLocalization(String languageCode, String expectedLanguage) {
        LanguagePage languagePage = new LanguagePage();

        languagePage.openLanguageDropdownMenu();
        languagePage.selectLanguage(languageCode);
        String actualLanguage = languagePage.getCurrentLanguage();

        softAssert.assertEquals(actualLanguage, expectedLanguage, "Incorrect language after selection");
    }
}
