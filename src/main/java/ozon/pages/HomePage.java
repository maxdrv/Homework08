package ozon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ozon.steps.BaseSteps;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HomePage extends BasePageObject {

    @FindBy(xpath = "//div[@class = 'jsUserMenuWrap']")
    WebElement myOzonMenu;

    @FindBy(xpath = "//div[contains(text(), 'Вход')]")
    WebElement myOzonMenuSignIn;

    //input[@class = 'search-input']
    //input[@type = 'text']
    @FindBy(xpath = "//input[@type = 'text']")
    WebElement searchInput;

    @FindBy(xpath = "//a[@href = '/context/cart']")
    WebElement moveToCardButton;
    //a[@class = 'eMyOzon_ItemWrap']//span[contains(text(), 'Корзина')]
    @FindBy(xpath = "//a[@href = '/context/cart']")
    WebElement moveToCardButton2;

    @FindBy(xpath = "//span[@class = 'bottom-block']/span")
    WebElement myOzonUserName;

    @FindBy(xpath = "//div[@class = 'sale-block']//button[@class = 'buy-button blue-cream enlarged button flat-button tile-buy-button']")
    List<WebElement> addToCardButtonsList;

    public HomePage() {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public HomePage myOzonPopUpMenu() {
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(myOzonMenu).build().perform();
        return this;
    }

    public LoginPage signIn() {
        //myOzonMenuSignIn.click();
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(myOzonMenu).build().perform();
        action.moveToElement(myOzonMenu, 0, 160).click().build().perform();
        return new LoginPage();
    }

    public HomePage searchItems(String value) {


        waitForClickable(searchInput);
        fillField(searchInput, value);
        Actions action = new Actions(BaseSteps.getDriver());
        action.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public ArrayList<String> addItemsToCard(int amountOfItems) {
/*        ArrayList<String> namesOfItems = new ArrayList<>();
        for (int i = 0; i < amountOfItems; i++) {
            addToCardButtonsList.get(i).click();
            namesOfItems.add(addToCardButtonsList.get(i).getText());
        }
        return namesOfItems;*/

        String tile = "//div[@class = 'tile']";
        String name = "//div[@class = 'tile']//p[@class = 'name']";
        ArrayList<String> namesOfItems = new ArrayList<>();
        for (int i = 1; i <= amountOfItems; i++) {
            String patern = String.format("//div[@class = 'item-view']/following-sibling::div[%d]", i);
            String nameItemXpath = String.format("%s//p[@class = 'name']", patern);
            String descriptionItem = BaseSteps.getDriver().findElement(By.xpath(nameItemXpath)).getText();
            namesOfItems.add(descriptionItem);

            //span[contains(text(), 'корзину')]
            //button[@class = 'buy-button blue-cream enlarged button flat-button tile-buy-button']
            String toCardXpath = String.format("%s//span[contains(text(), 'корзину')]", patern);
            BaseSteps.getDriver().findElement(By.xpath(toCardXpath)).click();
        }
        return namesOfItems;

    }

    public CardPage moveToCard() {
        //WebElement el = BaseSteps.getDriver().findElement(By.xpath("//a[@href = '/context/cart']"));
        waitForClickable(moveToCardButton);
        moveToCardButton.click();
        return new CardPage();
    }

    public CardPage moveToCard2() {
        WebElement el = BaseSteps.getDriver().findElement(By.xpath("//a[@href = '/context/cart']"));
        searchItems("a");
        waitForClickable(el);
        el.click();
        return new CardPage();
    }

    public LoginPage repeatSignIn() {
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
