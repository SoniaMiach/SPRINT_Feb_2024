package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.BasePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class UltramarketPage extends BasePage {
    private SelenideElement caregoryTab(String categoryName) {
        return $x(format("//li[@title='%s']/a/span", categoryName));
    }

    private SelenideElement subcaregoryTab(String subcategoryName) {
        return $x(format("//span[contains(text(),'%s') and contains(@class,'NestedList')]", subcategoryName));
    }

    public void clickCategoryTab(String categoryName) {
        caregoryTab(categoryName).shouldBe(interactable).click();
    }

    public void clickSubcategoryButton(String subcategoryName) {
        subcaregoryTab(subcategoryName).shouldBe(interactable).click();
    }

    public void clickFirstProduct() {
        $x("(//span[@data-testid=\"product_tile_inner\"])[1]").shouldBe(interactable).click();
    }

    public String getProductPath() {
        ElementsCollection pathElements = $$x("//div[contains(@class,'Breadcrumbs_noTopMargin')]//a").shouldHave(sizeGreaterThan(0));
        String path = "";
        for(SelenideElement element : pathElements){
            path += element.getText() + " ";
        }
        return path;
    }
}
