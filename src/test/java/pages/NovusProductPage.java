package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.collections.SizeGreaterThan;
import common.BasePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;

public class NovusProductPage extends BasePage {

    public ElementsCollection getFullPriceElements() {
        return $$x("//div[@data-marker='Old Price']/span[contains(@class, 'value')]").shouldHave(sizeGreaterThan(29));
    }

    public ElementsCollection getDiscountPriceElements() {
        return $$x("//div[@data-marker='Discounted Price']/span[contains(@class, 'value')]").shouldHave(sizeGreaterThan(29));
    }
}
