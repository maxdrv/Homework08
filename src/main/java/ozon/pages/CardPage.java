package ozon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ozon.steps.BaseSteps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardPage extends BasePageObject {

    @FindBy(xpath = "//div[@class = 'bFlatButton mHuge mGreen jsMakeOrder']")
    WebElement confirmTheOrderButton;

    //bIconButton mRemove mGray jsRemoveAll
    @FindBy(xpath = "//div[@class = 'jsViewCollection jsChild_DOM_split']/div[1]//div[@class = 'eCartControls_buttons']")
    WebElement removeItemsButtonInStock;

    @FindBy(xpath = "//div[@class = 'eCartControls_buttons']")
    List<WebElement> removeButtonsList;

    @FindBy(xpath = "//div[@class = 'bCartSplit mType_BannedForArea jsChild_DOM_split_5232']//div[@class = 'bIconButton mRemove mGray jsRemoveAll']")
    WebElement removeItemsButtonBanned;

    @FindBy(xpath = "//a[contains(text(), 'Начать покупки')]")
    WebElement startShoppingButton;

    @FindBy(xpath = "//span[@class = 'jsInnerContentpage_title']")
    WebElement emptyMessageShpoongCard;

    @FindBy(xpath = "//div[@class = 'eMyOzon_Item_Top ']")
    WebElement logOutFromCard;

    public CardPage() {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public CardPage checkCardItems(HashSet<String> items) {
        Set<String> cardItems = new HashSet<>();
        String firstItem = "//div[@class = 'jsViewCollection jsChild_DOM_items']/div";
        String spanXpath = "//span[@class = 'eCartItem_nameValue']";
        String mainPatern = "//div[@class = 'jsViewCollection jsChild_DOM_items']/div/following-sibling::div[%d]";

        cardItems.add(BaseSteps.getDriver().findElement(By.xpath(firstItem + spanXpath)).getText());
        for (int i = 1; i < items.size(); i++) {
            String paternIter = String.format(mainPatern, i);
            String nameItemXpath = paternIter + spanXpath;
            String descriptionItem = BaseSteps.getDriver().findElement(By.xpath(nameItemXpath)).getText();
            cardItems.add(descriptionItem);
        }
        Assert.assertEquals("Коллекции не равны",cardItems, items);
        return this;
    }

    public CardPage removeItemsFromCard() {
        waitForVisible(confirmTheOrderButton);
        int amountOfRemoveButtons = removeButtonsList.size();

/*        for (WebElement element : removeButtonsList) {
            waitForVisible(element);
            element.click();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        for (int i = 0; i < amountOfRemoveButtons; i++) {

            WebElement firstButton = BaseSteps.getDriver().findElement(By.xpath("//div[@class = 'jsViewCollection jsChild_DOM_split']/div[1]//div[@class = 'eCartControls_buttons']"));

            waitForVisible(firstButton);
            firstButton.click();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public CardPage checkShoppingCardForEmpty(String expectedText) {
        String availableText = emptyMessageShpoongCard.getText();
        Assert.assertEquals("Заголовок корзины не соответствует ожидаемому",expectedText, availableText);
        return this;
    }

    public HomePage myOzonMenuSignOutClick() {
        //WebElement popUp = driver.findElement(By.xpath("//div[@class = 'eMyOzon_Item_Top ']"));
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(logOutFromCard).build().perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        action.moveToElement(logOutFromCard, 0, 171).click().build().perform();
        return new HomePage();
    }
}
