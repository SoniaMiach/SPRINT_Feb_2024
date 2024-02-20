package pages;

import common.TestInit;
import static com.codeborne.selenide.Selenide.open;

public class VarusListsPage extends TestInit {

    public void navigate() {
        open("https://varus.zakaz.ua/uk/lists/");
    }
}
