package ozon.steps;

import ozon.pages.HomePage;
import ozon.pages.LoginPage;
import ozon.util.TestBaseProperties;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Properties;

public class LoginPageSteps{

    public static Properties properties = TestBaseProperties.INSTANCE.getProperties();

    @Step("Войти используя email")
    public void signInUsingMailClick() {
        new LoginPage().signInUsingMailClick();
    }

    @Step("Ввод логина и пароля")
    public void login() {
        new LoginPage().login(properties.getProperty("username"), properties.getProperty("password"));
    }

}
