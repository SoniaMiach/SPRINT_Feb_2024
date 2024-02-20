package pages;

import common.TestInit;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class VarusProductViewPage extends TestInit {


    public void clickButtonAddToFavorite() {
        $(By.xpath("(//button[@data-marker='Add product to list']/span)[1]")).click();
    }
}
