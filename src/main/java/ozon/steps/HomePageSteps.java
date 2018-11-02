package ozon.steps;

import ozon.pages.HomePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

public class HomePageSteps {

    @Step("Выбрано выпадающее меню с кнопкой входа")
    public void myOzonPopUpMenu() {
        new HomePage().myOzonPopUpMenu();
    }

    @Step("Нажатие по кнопке входа")
    public void myOzonSignInClick() {
        new HomePage().signIn();
    }

    @Step("Поиск предмета {0}")
    public void searchItems(String item) {
        new HomePage().searchItems(item);
    }

    @Step("Добавление {0} предметов в корзину")
    public ArrayList<String> addItemsToCard(int amountOfItems) {
        return new HomePage().addItemsToCard(amountOfItems);
    }

    @Step("Переход в корзину")
    public void moveToCard() {
        new HomePage().moveToCard();
    }

    @Step("Переход в корзину2")
    public void moveToCard2() {
        new HomePage().moveToCard2();
    }

    @Step("Выбрано выпадающее меню с кнопкой входа версия 2")
    public void repeatPopUpMenu() {
        new HomePage().repeatSignIn();
    }

    @Step("Проверка имени пользователя")
    public void checkUserName(String name) {
        new HomePage().validateName(name);
    }
}
