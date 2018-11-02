package ozon.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashSet;

public class ScenarioSteps {


    HomePageSteps homePageSteps = new HomePageSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    CardPageSteps cardPageSteps = new CardPageSteps();

    HashSet<String> items = new HashSet<>();

    @When("^Пользователь зашев в меню myOzon и выбрал кнопку$")
    public void choseSignIn() {
        homePageSteps.myOzonSignInClick();
    }

    @When("^Пользователь выбрал вход с использованием почты$")
    public void signInUsingMail() {
        loginPageSteps.signInUsingMailClick();
    }

    @When("^Пользователь ввел логин: \"(.+)\" и пароль: \"(.+)\"$")
    public void enterUsernamePassword(String username, String password) {
        loginPageSteps.login(username, password);
    }

    @Then("^Выполнить поиск по \"(.+)\"$")
    public void makeSearchOnSite(String item) {
        homePageSteps.searchItems(item);
    }

    @And("^Из результатов поиска добавьте в корзину (\\d+) товаров$")
    public void addItemsInCard(int amountOfItems) {
        items =  homePageSteps.addItemsToCard(amountOfItems);
    }

    @Then("^Перейти в корзину$")
    public void moveToShoppingCard() {
        homePageSteps.moveToCard();
    }

    @When("^Убедиться что все добавленные товары находятся в корзине$")
    public void checkItemsInShoppingCard() {
        cardPageSteps.checkCardItems(items);
    }

    @Then("^Удалить все товары из корзины$")
    public void deleteAllItemsFromCard() {
        cardPageSteps.removeItemsFromCard();
    }

    @And("^Разлогиниться с сервиса$")
    public void logOutFromService() {
        cardPageSteps.myOzonMenuSignOutClick();
    }

    @And("^Проверить, что \"(.+)\"$")
    public void checkShoppingCardForEmpty(String expectedText) {
        cardPageSteps.checkShoppingCardForEmpty(expectedText);
    }

    @When("^Повторный вход в аккаунт$")
    public void repeatLogInMenu() {
        homePageSteps.repeatPopUpMenu();
    }

}
