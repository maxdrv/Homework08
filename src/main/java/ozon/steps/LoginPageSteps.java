package ozon.steps;

import ozon.pages.HomePage;
import ozon.pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPageSteps {

    @Step("Войти используя email")
    public void signInUsingMailClick() {
        new LoginPage().signInUsingMailClick();
    }

    @Step("Ввод логина {0} и пароля {1}")
    public void login(String username, String password) {
        new LoginPage().login(username,password);
    }

}
