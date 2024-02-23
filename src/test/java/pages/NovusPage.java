package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import common.BasePage;
import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class NovusPage extends BasePage {

    private static final SelenideElement MARKET_OFFERS = $x("//a[@data-marker='offers widget']");
    private static final SelenideElement OPEN_CITY = $x("//div[contains(@class,'SelectStyled')]");
    private static final ElementsCollection PROMOTIONS_OF_CITY = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");
    private static final ElementsCollection PROMOTIONS_OF_SPECIFIC_CITY = $$x("//*[@data-testid='offers_list']/*[@data-marker='Offer']");
    private static final String SPECIFIC_CITY = "//*[contains(text(), '%s')]";
    private static final SelenideElement POP_CART = $x("//button[@data-marker='Close popup']");
    private static final SelenideElement CHANGE_REGION_BUTTON = $x("//span[@class=\"jsx-f54e3ec21d41507f AddressButton__label\"]");
    private static final SelenideElement SELF_PICKUP_BUTTON = $x("//li[@id=\"react-tabs-2\"]");
    private static final SelenideElement TO_BUY_BUTTON = $x("//button[@class=\"jsx-966ed87a73bbaf75 Button Button_primary Button_large Button_fullWidth\"]");
    private static final SelenideElement REGION = $x("//span[contains(@class,'AddressButton__label')]");
    private static final SelenideElement REGION_FIELD = $x("//div[@class=\"SelectStyled__input\"]//input[@id='delivery_service_select']");

    public void clickPromotionsStore() {
        MARKET_OFFERS.shouldBe(interactable).click();
    }

    public void clickOpenCity() {
        OPEN_CITY.shouldBe(visible).click();
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

    public boolean visibilityPromotionsOfAnotherCity() {

        return PROMOTIONS_OF_SPECIFIC_CITY.shouldHave(sizeGreaterThan(0)).size() > 0;
    }

    public void clickChangeRegionButton() {
        CHANGE_REGION_BUTTON.shouldBe(interactable).click();
    }

    public void clickSelfPickupButton()pull  {
        SELF_PICKUP_BUTTON.shouldBe(interactable).click();
    }

    public String getTextRegion() {
        return REGION.shouldBe(interactable).getText();
    }

    public void insertRegionField(String nameRegion) {
        REGION_FIELD.shouldBe(interactable).setValue(nameRegion).pressEnter();
    }

    public SelenideElement specificCity(String cityName) {
        return $x(String.format(SPECIFIC_CITY, cityName)).shouldBe(visible);
    }

    private SelenideElement seeAllCategoryButton(String categoryName) {
        return $x(format("//h2[text()='%s']/../..//span[text()='Переглянути всі']", categoryName));
    }

    @Step("Go to the category: {categoryName}")
    public void clickSeeAllCategoryButton(String categoryName) {
        seeAllCategoryButton(categoryName).shouldBe(visible).click();
    }

    public void closePopCart() {
        try {
            POP_CART.shouldBe(interactable, Duration.ofSeconds(10)).click();
        } catch (ElementNotFound e) {
            System.out.println("Exception found:" + e.getMessage());
        }
    }
}