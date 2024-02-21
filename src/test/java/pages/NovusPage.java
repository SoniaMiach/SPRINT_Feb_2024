package pages;

import common.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NovusPage extends BasePage {

    private static final SelenideElement NOVUS = $x("//a[@href='https://novus.zakaz.ua/uk/']");
    private static final SelenideElement OFFERS = $("[data-marker='offers widget']");
    private static final SelenideElement OPEN_CITY = $x("//*[@class='SelectStyled css-2b097c-container']");
    private static final SelenideElement ANOTHER = $x("//*[contains(text(), 'Рівне')]");
    private static final ElementsCollection PROMOTIONS = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");
    private static final ElementsCollection PROMOTIONS_OF_ANOTHER_CITY = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");

    public void clickNovus() {NOVUS.shouldBe(visible).click();}

    public void clickPromotionsStore() {OFFERS.shouldBe(interactable).click();}

    public void visibilityPromotions() {PROMOTIONS.shouldHave(sizeGreaterThan(0));}

    public void clickOpenCity() {OPEN_CITY.shouldBe(visible).click();}

    public void choseAnotherCity() {ANOTHER.shouldBe(visible).click();}

    public void visibilityPromotionsOfAnotherCity() {PROMOTIONS_OF_ANOTHER_CITY.shouldHave(sizeGreaterThan(0));}

    public int getNumberOfPromotions() {return PROMOTIONS.size();}

    public int getNumberOfPromotionsInAnotherCity() {return PROMOTIONS_OF_ANOTHER_CITY.size();}
}