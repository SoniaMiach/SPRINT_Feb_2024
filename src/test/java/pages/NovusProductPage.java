package pages;

import com.codeborne.selenide.ElementsCollection;
import common.BasePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;

public class NovusProductPage extends BasePage {

    private static final ElementsCollection ALL_FULL_PRICE_ELEMENTS = $$x("//div[@data-marker='Old Price']/span[contains(@class, 'value')]");
    private static final ElementsCollection ALL_DISCOUNT_PRICE_ELEMENTS = $$x("//div[@data-marker='Discounted Price']/span[contains(@class, 'value')]");

    public ElementsCollection getFullPriceElements() {
        return ALL_FULL_PRICE_ELEMENTS.shouldHave(sizeGreaterThan(29));
    }

    public ElementsCollection getDiscountPriceElements() {
        return ALL_DISCOUNT_PRICE_ELEMENTS.shouldHave(sizeGreaterThan(29));
    }
}
