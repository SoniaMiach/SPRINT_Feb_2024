package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;

public class MetroProductListPage {
    public final SelenideElement SEARCH_INPUT = $x("(//*[@data-marker='Search Input']) ");
    public final SelenideElement SEARCH_PRODUCT_NAME = $x("(//*[@data-marker='Search Input'])[1]");
    public final SelenideElement SORT_MENU_BUTTON = $x("//span[contains(@class, 'jsx-b88901bddeb326') and contains(@class, 'ContentSorterDropdown__selectedLabel')]");
    public final SelenideElement SORT_LOW_PRICE = $x("//*[@data-testid='price_asc']");
    public final ElementsCollection SORT_LOW_TO_HIGH_PRICES = $$x("//div[contains(@class, 'ProductsBox__listItem')]//span[contains(@class,'Price__value_caption')]");
    public final SelenideElement HOVER_TO_PRODUCT = $x("//div[contains(@class, 'ProductsBox__listItem')][1]");
    public final SelenideElement ADD_TO_CART_PRODUCT = $x("(//*[@data-testid='add-to-cart'])[1]");
    public final SelenideElement CLICK_CART_BUTTON = $x("(//*[@data-testid='cart_button'])");
    public final SelenideElement SELECT_DELIVERY_TYPE = $x("(//*[@data-marker='Pickup'])");
    public final SelenideElement ENTER_RETURN_TO_SHOPPING = $x("(//*[@data-marker='To shopping'])");
    public final SelenideElement NAME_OF_PRODUCT_IN_CART = $x("//div[contains(@class, 'CartPopupItem__infoTitle')]");
    public final SelenideElement FIRST_PRODUCT_TITLE_IN_PRODUCTS_LIST= $x("(//div[contains(@class, 'ProductsBox__listItem')]//span[@data-testid='product_tile_title'])[1]");

    public String cheapestProductTitle;

    public void clickSearchInput() {
        SEARCH_INPUT.click();

    }

    public void searchProductName(String productName) {
        SEARCH_PRODUCT_NAME.setValue(productName).pressEnter();


    }

    public void clickSortMenuButton() {
        SORT_MENU_BUTTON.click();

    }


    public void sortLowPrice() {
        SORT_LOW_PRICE.click();
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());

        }
    }

    public void hoverToProduct() {
        HOVER_TO_PRODUCT.hover();

    }

    public void addToCartProduct() {
        ADD_TO_CART_PRODUCT.click();

    }

    public void clickCartButton() {
        CLICK_CART_BUTTON.click();

    }

    public void selectDeliveryType() {
        SELECT_DELIVERY_TYPE.click();
        ENTER_RETURN_TO_SHOPPING.click();

    }


    public void saveCheapProductName() {
        cheapestProductTitle=FIRST_PRODUCT_TITLE_IN_PRODUCTS_LIST.text();

    }
}




