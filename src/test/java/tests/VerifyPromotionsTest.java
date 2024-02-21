package tests;

import common.TestInit;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.NovusPage;

import static com.codeborne.selenide.Selenide.switchTo;


public class VerifyPromotionsTest extends TestInit {
    NovusPage novusPage = new NovusPage();

    @Test(description = "Positive Test -Verify Promotions and Discounts for Novus Store.")
    @Description("SF2-9")
    public void verifyPromotions() {

        novusPage.clickNovus();
        switchTo().window(1);
        novusPage.clickPromotionsStore();
        novusPage.visibilityPromotions();
        novusPage.clickOpenCity();
        novusPage.specificCity("Рівне");
        novusPage.visibilityPromotionsOfAnotherCity();

        int numberOfPromotions = novusPage.getNumberOfPromotions();
        int numberOfPromotionsInAnotherCity = novusPage.getNumberOfPromotionsInAnotherCity();

        softAssert.assertEquals(numberOfPromotions, numberOfPromotionsInAnotherCity,
                "Number of promotions is not equal for two cities");
    }
}
