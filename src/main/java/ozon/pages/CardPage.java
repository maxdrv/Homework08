package ozon.pages;

import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.By;
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

    //a[contains(text(), 'Начать покупки')]
    //a[@class = 'bFlatButton mHuge']
    @FindBy(xpath = "//a[@class = 'bFlatButton mHuge']")
    WebElement startShoppingButton;

    @FindBy(xpath = "//span[@class = 'jsInnerContentpage_title']")
    WebElement titleOfCardPage;

    @FindBy(xpath = "//div[@class = 'eMyOzon_Item_Top ']")
    WebElement signOutFromCard;

    @FindBy(xpath = "//span[@class = 'eCartItem_nameValue']")
    List<WebElement> itemsInCardList;

    @FindBy(xpath = "eCheckoutBlock_step mTotal")
    WebElement supportingElement;

    @FindBy(xpath = "//div[@class = 'jsViewCollection jsChild_DOM_split']/div[1]//div[@class = 'eCartControls_buttons']")
    WebElement removeButtonFirst;

    public CardPage() {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public CardPage checkCardItems(ArrayList<String> items) {
        ArrayList<String> cardItems = new ArrayList<>();
        for (WebElement element : itemsInCardList) {
            cardItems.add(element.getText());
        }
        Asserts.check(cardItems.containsAll(items), "В корзине нет всех добавленных элементов");
        return this;
    }

    public CardPage removeItemsFromCard() {
        waitForClickable(confirmTheOrderButton);

        for (int i = 0; i < removeButtonsList.size(); i++) {
            WebElement firstButton = BaseSteps.getDriver().findElement(By.xpath("//div[@class = 'jsViewCollection jsChild_DOM_split']/div[1]//div[@class = 'eCartControls_buttons']"));
            //WebElement supEl = BaseSteps.getDriver().findElement(By.xpath("//div[@class = 'bFlatButton mWhite jsActivate']"));
            //waitForClickable(supEl);
            waitForClickable(firstButton);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            firstButton.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //waitForClickable(startShoppingButton);
        return this;
    }

    public CardPage checkCardTitle(String expectedText) {
        checkText(titleOfCardPage, expectedText);
        return this;
    }

    public HomePage signOutFromCard() {
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(signOutFromCard).build().perform();
        action.moveToElement(signOutFromCard, 0, 171).click().build().perform();
        return new HomePage();
    }
//    public CardPage removeItemsFromCard() {
//        waitForVisible(confirmTheOrderButton);
//        int amountOfRemoveButtons = removeButtonsList.size();
//
///*        for (WebElement element : removeButtonsList) {
//            waitForVisible(element);
//            element.click();
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }*/
//        for (int i = 0; i < amountOfRemoveButtons; i++) {
//
//            WebElement firstButton = BaseSteps.getDriver().findElement(By.xpath("//div[@class = 'jsViewCollection jsChild_DOM_split']/div[1]//div[@class = 'eCartControls_buttons']"));
//
//            waitForVisible(firstButton);
//            firstButton.click();
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return this;
//    }



}
