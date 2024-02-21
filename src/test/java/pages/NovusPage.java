package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NovusPage extends BasePage {

    private final SelenideElement novus = $x("//a[@href='https://novus.zakaz.ua/uk/']");
    private final SelenideElement offers = $("[data-marker='offers widget']");
    private final SelenideElement openCity = $x("//*[@class='SelectStyled css-2b097c-container']");
    private final SelenideElement anotherCity = $x("//*[contains(text(), 'Рівне')]");
    private final ElementsCollection promotions = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");
    private final ElementsCollection promotionsOfAnotherCity = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");

    public void clickNovus() {novus.shouldBe(visible).click();}

    public void clickPromotionsStore() {
        offers.shouldBe(interactable).click();
    }

    public void visibilityPromotions() {promotions.shouldHave(size(5)); }

    public void clickOpenCity() {
        openCity.shouldBe(visible).click();
    }

    public void choseAnotherCity() {
        anotherCity.shouldBe(visible).click();
    }

    public void visibilityPromotionsOfAnotherCity() {
        promotionsOfAnotherCity.shouldHave(size(4));
    }

    public int getNumberOfPromotions() {return promotions.size();}

    public int getNumberOfPromotionsInAnotherCity() {
        return promotionsOfAnotherCity.size();
    }
}