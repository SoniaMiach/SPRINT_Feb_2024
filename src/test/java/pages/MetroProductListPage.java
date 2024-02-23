package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class MetroProductListPage {
    public String cheapestProductTitle;

    public MetroProductListPage clickSearchInput() {
        $x("(//*[@data-marker='Search Input']) ").click();
        return this;
    }

    public MetroProductListPage searchProductName(String productName) {
        $x("(//*[@data-marker='Search Input'])[1]").setValue(productName).pressEnter();
        return this;
    }

    public MetroProductListPage clickSortMenuButton() {
        $x("//span[contains(@class, 'jsx-b88901bddeb326') and contains(@class, 'ContentSorterDropdown__selectedLabel')] ").click();
        return this;
    }


    public MetroProductListPage sortLowPrice() {
        $x("//*[@data-testid='price_asc']").click();
        return this;
    }

    public MetroProductListPage hoverToProduct() {
        $x("//div[contains(@class, 'ProductsBox__listItem')][1]").hover();
        return this;
    }

    public MetroProductListPage addToCartProduct() {
        $x("(//*[@data-testid='add-to-cart'])[1]").click();
        return this;
    }

    public MetroProductListPage clickCartButton() {
        $x("(//*[@data-testid='cart_button'])").click();
        return this;
    }

    public MetroProductListPage selectDeliveryType() {
        $x("(//*[@data-marker='Pickup'])").click();
        $x("(//*[@data-marker='To shopping'])").click();
        return this;

    }
    public MetroProductListPage checkProductInCartPage(String expectedTitle) {
        String actualTitle=$x("//div[contains(@class, 'CartPopupItem__infoTitle')]").text();

        assertEquals(actualTitle, expectedTitle);
        return this;
        }


    public MetroProductListPage saveCheapProductName() {
        cheapestProductTitle=$x("(//div[contains(@class, 'ProductsBox__listItem')]//span[@data-testid='product_tile_title'])[1]").text();

        return this;
    }
}




