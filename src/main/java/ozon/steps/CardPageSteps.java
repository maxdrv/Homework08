package ozon.steps;

import io.qameta.allure.Step;
import ozon.pages.CardPage;


import java.util.ArrayList;

public class CardPageSteps {


    @Step("Проверка соответствя содержимого корзины")
    public void checkCardItems(ArrayList<String> items) {
        new CardPage().checkCardItems(items);
    }

    @Step("Удаление предметов из корзины")
    public void removeItemsFromCard() {
        new CardPage().removeItemsFromCard();
    }

    @Step("Выход из корзины")
    public void signOutFromCardPage() {
        new CardPage().signOutFromCard();
    }

    @Step("Проверка наличия текста {0}")
    public void checkShoppingCardForEmpty(String expectedText) {
        new CardPage().checkCardTitle(expectedText);
    }
}
