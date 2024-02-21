package pages;

import com.codeborne.selenide.Selenide;
import common.TestInit;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ZakazUaHomePage extends TestInit {

    public void clickLoginButton() {
        $x("//span[text()='Увійти']").click();
    }

    public void enterPhone(String phoneNumber) {
        $x("//input[@id ='phone']").setValue(phoneNumber);
    }

    public void enterPassword(String pass) {
        $x("//input[@id ='password']").setValue(pass);
    }

    public void clickSubmitButton() {
        $x("//button[@data-marker='Submit']").click();
    }

    public boolean isLogButtonDisplayed () {
            return Selenide.$x("//div/span[text()='Акаунт']").exists();
        }

        @Step("Go to Novus page")
    public void clickNovusShopButton() {
        $x("//a[@data-marker='NOVUS']").click();
        }
    }
