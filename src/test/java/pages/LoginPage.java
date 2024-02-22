package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import common.TestInit;

import static com.codeborne.selenide.Selectors.byTagName;
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

    public boolean isLogButtonDisplayed() {
        return Selenide.$x("//div/span[text()='Акаунт']").exists();
    }

        public final String FIRST_VARUS_CONTAINER_ITEM = "(//img[@alt='varus']/ancestor::div[1]/ancestor::div[1]/following-sibling::div[1]//div[contains(@class,'Slider__item')])[1]";
        public String productName;

        public void clickFirstVarusPromotialProduct() {
            $x(("(//img[@alt='varus']/ancestor::div[1]/ancestor::div[1]/following-sibling::div[1]//div[contains(@class,'Slider__item')])[1]")).click();
        }


        public LoginPage saveFirstProductName() {

            SelenideElement firstProductFromVarusPromotionList = $x(FIRST_VARUS_CONTAINER_ITEM);
            productName = firstProductFromVarusPromotionList.findAll(byTagName("h3")).first().text();
            return this;
        }
    }



