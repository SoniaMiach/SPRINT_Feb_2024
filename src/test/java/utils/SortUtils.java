package utils;

import com.codeborne.selenide.ElementsCollection;

public class SortUtils {
    public static boolean checkSortedLowToHigh(ElementsCollection prices) {
        if (prices.size() < 2) {
            return true;
        }


        for (int i = 1; i < prices.size(); i++) {
            String price1 = prices.get(i - 1).text();
            String price2 = prices.get(i).text();


            if (Double.parseDouble(price2) < Double.parseDouble(price1)) {
                return false;
            }
        }

        return true;
    }

}
