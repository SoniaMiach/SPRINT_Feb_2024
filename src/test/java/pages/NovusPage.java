package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NovusPage extends BasePage {

    private static final SelenideElement NOVUS_MARKET = $x("//a[@href='https://novus.zakaz.ua/uk/']");
    private static final SelenideElement OFFERS_OF_MARKET = $("[data-marker='offers widget']");
    private static final SelenideElement OPEN_CITY = $x("//*[@class='SelectStyled css-2b097c-container']");
    private static final ElementsCollection PROMOTIONS_OF_CITY = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");
    private static final ElementsCollection PROMOTIONS_OF_SPECIFIC_CITY = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");
    private static final String SPECIFIC_CITY = "//*[contains(text(), '%s')]";


    public void clickNovus() {
        NOVUS_MARKET.shouldBe(visible).click();
    }

    public void clickPromotionsStore() {
        OFFERS_OF_MARKET.shouldBe(interactable).click();
    }

    public void visibilityPromotions() {
        PROMOTIONS_OF_CITY.shouldHave(sizeGreaterThan(0));
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

    public SelenideElement specificCity(String cityName) {
        return $x(String.format(SPECIFIC_CITY, cityName)).shouldBe(visible);
    }
}