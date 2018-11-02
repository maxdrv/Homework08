package ozon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ozon.steps.BaseSteps;

import java.time.Duration;

public class BasePageObject {

    public BasePageObject() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void waitForVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 5);
        wait.pollingEvery(Duration.ofMillis(300))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void mouseOver(WebElement element) {
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );"
                + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor)BaseSteps.getDriver()).executeScript(code, element);
    }

    public void clickJS(WebElement element) {
        ((JavascriptExecutor)BaseSteps.getDriver()).executeScript("arguments[0].click", element);
    }

}