package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class WinetimeProductPage extends BasePage {

    private static final SelenideElement MIN_PRICE = $x("//input[@data-marker='Filter Price Min']");
    private static final SelenideElement MAX_PRICE = $x("//input[@data-marker='Filter Price Max']");
    private static final SelenideElement APPLY_PRICE_FILTER_BUTTON = $x("//button[@data-marker='Filter Price OK']");
    private static final SelenideElement PRICE_FILTER = $x("//div[contains(@class, 'CatalogActiveFiltersList__filter')]");
    private static final ElementsCollection DISPLAYED_PRICES = $$x("//span[contains(@class, 'Price__value_caption')]");
    private static final SelenideElement LOADER = $x("//div[contains(@class,'CategoryLoader__ring')]");

    public void enterExpectedPrices(String minPrice, String maxPrice) {
        MIN_PRICE.setValue(minPrice);
        MAX_PRICE.setValue(maxPrice);
    }

    public void clickApplyPriceFilter() {
        APPLY_PRICE_FILTER_BUTTON.shouldBe(visible).click();
    }

    public String getFilter() {
        return PRICE_FILTER.shouldBe(visible).getText();
    }

    public ElementsCollection getDisplayedPriceElements() {
        return DISPLAYED_PRICES.shouldHave(sizeGreaterThan(0));
    }

    public void waitLoaderDisappear() {
        LOADER.shouldBe(visible);
        LOADER.shouldBe(disappear, Duration.ofSeconds(5));
    }
}
