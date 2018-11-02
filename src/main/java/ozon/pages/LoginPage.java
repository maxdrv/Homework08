package ozon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ozon.steps.BaseSteps;

public class LoginPage extends BasePageObject {
    //a[@class = 'link-base']
    //a[contains(text(), 'Войти по почте')]"
    @FindBy(xpath = "//a[@class = 'link-base']")
    WebElement signInUsingMail;

    @FindBy(xpath = "//input[@type = 'text']")
    WebElement signInMailInput;

    @FindBy(xpath = "//input[@type = 'password']")
    WebElement signInPasswordInput;

    //button[@type = 'button']
    //button[contains(text(), 'Войти')]
    @FindBy(xpath = "//button[@type = 'button']")
    WebElement signInButton;

    public LoginPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public LoginPage signInUsingMailClick() {
        waitForClickable(signInUsingMail);
        signInUsingMail.click();
        return this;
    }

    public HomePage login(String username, String password) {
        fillField(signInMailInput, username);
        fillField(signInPasswordInput, password);
        signInButton.click();
        String xpath = "//div[@class = 'modal-wrapper']";
        waitForInvisibility(xpath);
        return new HomePage();
    }


}
