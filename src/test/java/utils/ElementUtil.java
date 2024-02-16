package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

public class ElementUtil {
    public static List<String> getListOfStrings(ElementsCollection elements) {
        List<String> list = new ArrayList<>();
        for (SelenideElement element : elements) {
            list.add(element.getText());
        }
        return list;
    }
}

