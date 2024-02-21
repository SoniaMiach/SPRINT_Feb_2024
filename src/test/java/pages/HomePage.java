package pages;

import com.codeborne.selenide.SelenideElement;
import common.TestInit;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends TestInit {
    public final String FIRST_VARUS_CONTAINER_ITEM = "(//img[@alt='varus']/ancestor::div[1]/ancestor::div[1]/following-sibling::div[1]//div[contains(@class,'Slider__item')])[1]";
    public String productName;

    public void clickFirstVarusPromotialProduct() {
        $(By.xpath("(//img[@alt='varus']/ancestor::div[1]/ancestor::div[1]/following-sibling::div[1]//div[contains(@class,'Slider__item')])[1]")).click();
    }


    public HomePage saveFirstProductName() {

        SelenideElement firstProductFromVarusPromotionList = $(By.xpath(FIRST_VARUS_CONTAINER_ITEM));
        productName = firstProductFromVarusPromotionList.findAll(byTagName("h3")).first().text();
        return this;
    }
}


