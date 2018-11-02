package ozon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ozon.steps.BaseSteps;

import java.time.Duration;

public class BasePageObject {

    public BasePageObject() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
        wait.pollingEvery(Duration.ofMillis(300))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisiable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
        wait.pollingEvery(Duration.ofMillis(300))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisibility(String xpath) {
        new WebDriverWait(BaseSteps.getDriver(), 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    public void checkText(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedText, actualText);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clickElementJS(WebElement element) {
        ((JavascriptExecutor)BaseSteps.getDriver()).executeScript("arguments[0].click", element);
    }

    public void moveCursorToElement(WebElement element) {
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(element).build().perform();
    }

    public void moveCursorToElementJS(WebElement element) {
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );"
                + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor)BaseSteps.getDriver()).executeScript(code, element);
    }





}