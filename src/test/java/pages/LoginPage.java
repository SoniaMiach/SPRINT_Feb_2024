package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import common.TestInit;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends TestInit {

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
    }
