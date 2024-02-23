package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class SortUtils {
    public static boolean checkSortedLowToHigh(ElementsCollection prices) {
        // Перевірка, що колекція цін має принаймні два елементи
        if (prices.size() < 2) {
            return true; // Якщо в колекції менше двох елементів, вони автоматично вважаються відсортованими
        }

        // Перевірка кожної наступної ціни, щоб вона була більшою за попередню
        for (int i = 1; i < prices.size(); i++) {
            String price1 = prices.get(i - 1).text(); // Отримуємо текст попередньої ціни
            String price2 = prices.get(i).text();     // Отримуємо текст поточної ціни

            // Перевіряємо, чи поточна ціна більша за попередню
            if (Double.parseDouble(price2) < Double.parseDouble(price1)) {
                return false; // Якщо умова не виконується, повертаємо false
            }
        }

        return true; // Якщо всі ціни відсортовані від найнижчої до найвищої, повертаємо true
    }

}
