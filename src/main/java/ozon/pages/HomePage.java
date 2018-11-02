package ozon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ozon.steps.BaseSteps;

import java.util.HashSet;

public class HomePage extends BasePageObject {

    @FindBy(xpath = "//div[@class = 'jsUserMenuWrap']")
    WebElement myOzonPopUp;

    @FindBy(xpath = "//div[contains(text(), 'Вход')]")
    WebElement myOzonMenuSignIn;

    //input[@class = 'search-input']
    //input[@type = 'text']
    @FindBy(xpath = "//input[@type = 'text']")
    WebElement searchInput;

    @FindBy(xpath = "//a[@class = 'eMyOzon_ItemWrap']//span[contains(text(), 'Корзина')]")
    WebElement shoppingCardButton;

    @FindBy(xpath = "//span[@class = 'bottom-block']/span")
    WebElement myOzonUserName;

    public HomePage() {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public HomePage myOzonPopUpMenu() {
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(myOzonPopUp).build().perform();
        return this;
    }

    public LoginPage myOzonSignInClick() {
        //myOzonMenuSignIn.click();
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(myOzonPopUp).build().perform();
        action.moveToElement(myOzonPopUp, 0, 160).click().build().perform();
        return new LoginPage();
    }

    public HomePage searchItems(String item) {
        waitForVisible(searchInput);
        searchInput.sendKeys(item);
        Actions action = new Actions(BaseSteps.getDriver());
        action.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public HashSet<String> addItemsToCard(int amountOfItems) {
        String tile = "//div[@class = 'tile']";
        String name = "//div[@class = 'tile']//p[@class = 'name']";
        HashSet<String> namesOfItems = new HashSet<>();
        for (int i = 1; i <= amountOfItems; i++) {
            String patern = String.format("//div[@class = 'item-view']/following-sibling::div[%d]", i);
            String nameItemXpath = String.format("%s//p[@class = 'name']", patern);
            String descriptionItem = BaseSteps.getDriver().findElement(By.xpath(nameItemXpath)).getText();
            namesOfItems.add(descriptionItem);

            String toCardXpath = String.format("%s//span[contains(text(), 'корзину')]", patern);
            BaseSteps.getDriver().findElement(By.xpath(toCardXpath)).click();
        }
        return namesOfItems;
    }

    public CardPage moveToCard() {
        waitForVisible(shoppingCardButton);
        shoppingCardButton.click();
        return new CardPage();
    }

    public LoginPage repeatPopUpMenu() {
        WebElement PopUp = BaseSteps.getDriver().findElement(By.xpath("//div[@class = 'top-block']"));
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(PopUp).build().perform();

        action.moveToElement(PopUp, 0, 160).click().build().perform();
        System.out.println("finish");
        return new LoginPage();
    }

    public HomePage validateName(String expectedName) {
        String currentText = myOzonUserName.getText();
        Assert.assertEquals("Имя пользователя не соответствует", expectedName, currentText);
        return this;
    }

}
