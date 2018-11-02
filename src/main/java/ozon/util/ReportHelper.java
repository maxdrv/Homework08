package ozon.util;

import io.qameta.allure.Allure;

public class ReportHelper {

    public static void addTestDescription(String text) {
        Allure.addDescription(text);
    }

    public static void addTextAttach(String text) {
        Allure.addAttachment(text, "text/plain");
    }
}
