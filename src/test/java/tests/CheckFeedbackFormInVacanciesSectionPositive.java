package tests;

import com.github.javafaker.Faker;
import common.TestInit;
import io.qameta.allure.Description;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;

public class CheckFeedbackFormInVacanciesSectionPositive extends TestInit {

    HomePage homePage = new HomePage();
    CareersPage careersPage = new CareersPage();
    Faker faker = new Faker();

    @Test(description = "Check the feedback form in the vacancies section (Positive)")
    @Description("SF2-20")
    public void checkFeedbackFormInVacanciesSectionPositive() {

        homePage.clickVacanciesButton();
        switchTo().window(1);
        softAssert.assertTrue(url().contains("zakaz.global/careers"));

        careersPage.clickContactsButton();
        softAssert.assertTrue(careersPage.isFeedbackFormDisplayed());

        String generatedName = faker.name().firstName();
        String generatedPhoneNumber = faker.phoneNumber().phoneNumber();
        String generatedMessage = faker.lorem().paragraph(10);

        careersPage.insertTextInNameField("name", generatedName);
        careersPage.entryTextInPhoneField("tel", generatedPhoneNumber);
        careersPage.insertTextInEmailField("email", "test@gmail.com");
        careersPage.insertTextInMessageField("message", generatedMessage);

        careersPage.clickSendButton();
        softAssert.assertTrue(careersPage.isAdditionalWindowDisplayed());

        careersPage.clickOkButtonInAdditionalWindow();
        softAssert.assertTrue(careersPage.isAdditionalWindowNotDisplayed());
    }
}