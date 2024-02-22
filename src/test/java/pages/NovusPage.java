package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class NovusPage extends BasePage {


    private static final SelenideElement MARKET_OFFERS = $x("//a[@data-marker='offers widget']");
    private static final SelenideElement OPEN_CITY = $x("//div[contains(@class,'SelectStyled')]");
    private static final ElementsCollection PROMOTIONS_OF_CITY = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");
    private static final ElementsCollection PROMOTIONS_OF_SPECIFIC_CITY = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");
    private static final String SPECIFIC_CITY = "//*[contains(text(), '%s')]";


    public void clickPromotionsStore() {
        MARKET_OFFERS.shouldBe(interactable).click();
    }

    public void clickOpenCity() {
        OPEN_CITY.shouldBe(visible).click();
    }

    public void visibilityPromotionsOfAnotherCity() {
        PROMOTIONS_OF_SPECIFIC_CITY.shouldHave(sizeGreaterThan(0));
    }

    public int getNumberOfPromotions() {
        return PROMOTIONS_OF_CITY.size();
    }

    public int getNumberOfPromotionsInAnotherCity() {
        return PROMOTIONS_OF_SPECIFIC_CITY.size();
    }

    public boolean isPromotionsExists() {
        return PROMOTIONS_OF_CITY.shouldHave(sizeGreaterThan(0)).size() > 0;
    }

    public SelenideElement specificCity(String cityName) {
        return $x(String.format(SPECIFIC_CITY, cityName)).shouldBe(visible);
    }
}