package pages;

import common.TestInit;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends TestInit {
    public void clickFirstVarusPromotialProduct() {
        $(By.xpath("(//img[@alt='varus']/ancestor::div[1]/ancestor::div[1]/following-sibling::div[1]//div[contains(@class,'Slider__item')])[1]")).click();
    }


}


