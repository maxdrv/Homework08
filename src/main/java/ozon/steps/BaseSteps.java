package ozon.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.qameta.allure.Attachment;
import ozon.util.ReportHelper;
import ozon.util.TestBaseProperties;
import ozon.util.TestUtil;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public static WebDriver driver;
    public static Properties properties = TestBaseProperties.INSTANCE.getProperties();
    public static String baseUrl;

    public static WebDriver getDriver() {
        return driver;
    }


    @Before
    public static void setUp() throws Exception{
        ReportHelper.addTestDescription("Начало теста по www.ozon.ru");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");

        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver(options);
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver(options);
                break;
        }


        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        baseUrl = properties.getProperty("url");
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() throws Exception{
        ReportHelper.addTextAttach("Конец теста");
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
