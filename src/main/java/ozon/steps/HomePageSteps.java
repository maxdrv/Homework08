package ozon.steps;

import ozon.pages.HomePage;
import ozon.pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashSet;

public class HomePageSteps {

    @Step("Выбрано выпадающее меню с кнопкой входа")
    public void myOzonPopUpMenu() {
        new HomePage().myOzonPopUpMenu();
    }

    @Step("Нажатие по кнопке входа")
    public void myOzonSignInClick() {
        new HomePage().myOzonSignInClick();
    }

    @Step("Поиск предмета {0}")
    public void searchItems(String item) {
        new HomePage().searchItems(item);
    }

    @Step("Добавление {0} предметов в корзину")
    public HashSet<String> addItemsToCard(int amountOfItems) {
        return new HomePage().addItemsToCard(amountOfItems);
    }

    @Step("Переход в корзину")
    public void moveToCard() {
        new HomePage().moveToCard();
    }

    @Step("Выбрано выпадающее меню с кнопкой входа версия 2")
    public void repeatPopUpMenu() {
        new HomePage().repeatPopUpMenu();
    }

    @Step("Проверка имени пользователя")
    public void checkUserName(String name) {
        new HomePage().validateName(name);
    }
}
