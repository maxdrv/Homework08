package ozon.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ozon.util.TestBaseProperties;

import java.util.ArrayList;

public class ScenarioSteps {


    HomePageSteps homePageSteps = new HomePageSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    CardPageSteps cardPageSteps = new CardPageSteps();

    ArrayList<String> items = new ArrayList<>();

    @When("^Пользователь зашев в меню myOzon и выбрал кнопку$")
    public void choseSignIn() {
        homePageSteps.myOzonSignInClick();
    }

    @When("^Пользователь выбрал вход с использованием почты$")
    public void signInUsingMail() {
        loginPageSteps.signInUsingMailClick();
    }

    @When("^Пользователь ввел логини и пароль$")
    public void enterUsernamePassword() {
        loginPageSteps.login();
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
        cardPageSteps.signOutFromCardPage();
    }

    @And("^Проверить, что \"(.+)\"$")
    public void checkShoppingCardForEmpty(String expectedText) {
        cardPageSteps.checkShoppingCardForEmpty(expectedText);
    }

    @When("^Повторный вход в аккаунт$")
    public void repeatLogInMenu() {
        homePageSteps.repeatPopUpMenu();
    }

    @Then("^Перейти в корзину после$")
    public void moveToCard2() {
        homePageSteps.moveToCard2();
    }
}
