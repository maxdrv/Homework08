package ozon.steps;

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
    public void login(String username, String password) {
        new LoginPage().login(username, password);
    }

}
