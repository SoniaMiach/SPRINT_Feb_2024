package tests;

import com.google.gson.internal.bind.util.ISO8601Utils;
import common.TestInit;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import static utils.ConfigProvider.CITY;

public class NovaPostaDepartmentTest extends TestInit {

    HomePage homePage = new HomePage();

    @Test(description = "Positive Test-Verify Login Functionality")
    @Description("SF2-26")

    public void novaPostaDepartment() {

        homePage.clickEnterDeliveryAddressButton();
        homePage.clickNovaPostaButton();
        homePage.enterCity(CITY);
        homePage.clickLutskButton();
        homePage.clickDepartmentField();
        homePage.clickDepartmentButton();
        homePage.clickChooseDepartmentButton();

        Assert.assertTrue(homePage.isCollectionPresentOnPage(homePage.getStoreElements()),
                "Collection is not present on the page");

    }

}
