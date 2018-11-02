package ozon.steps;

import ozon.pages.CardPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashSet;

public class CardPageSteps {


    @Step("Проверка соответствя содержимого корзины")
    public void checkCardItems(HashSet<String> items) {
        new CardPage().checkCardItems(items);
    }

    @Step("Удаление предметов из корзины")
    public void removeItemsFromCard() {
        new CardPage().removeItemsFromCard();
    }

    @Step("Выход из корзины")
    public void myOzonMenuSignOutClick() {
        new CardPage().myOzonMenuSignOutClick();
    }

    @Step("Проверка наличия текста {0}")
    public void checkShoppingCardForEmpty(String expectedText) {
        new CardPage().checkShoppingCardForEmpty(expectedText);
    }
}