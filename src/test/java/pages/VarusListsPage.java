package pages;

import com.codeborne.selenide.SelenideElement;
import common.TestInit;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class VarusListsPage extends TestInit {
    public final String FIRST_ELEMENT_TITLE="//div[contains(@class, 'ProductsBox__listItem')]/descendant::span[@data-testid='product_tile_title']";

    public VarusListsPage navigate() {
        open("https://varus.zakaz.ua/uk/lists/");
        return this;
    }

    public void checkProductPresentWithName(String productName) {
        SelenideElement title = $$(By.xpath(FIRST_ELEMENT_TITLE)).first();
        String text = title.getText();
        Assert.assertEquals(text, productName);
    }
}
