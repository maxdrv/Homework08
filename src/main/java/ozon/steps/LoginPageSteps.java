package ozon.steps;

import io.qameta.allure.Step;
import ozon.pages.LoginPage;
import ozon.util.TestBaseProperties;

import java.util.Properties;

public class LoginPageSteps{

    public static Properties properties = TestBaseProperties.INSTANCE.getProperties();

    @Step("Войти используя email")
    public void signInUsingMailClick() {
        new LoginPage().signInUsingMailClick();
    }

    @Step("Ввод логина и пароля")
    public void login(String username, String password) {
        new LoginPage().login(username, password);
    }

}
