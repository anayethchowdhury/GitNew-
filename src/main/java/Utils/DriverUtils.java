package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class DriverUtils {
    static Properties prop;

    public static void setChromePath() {
        System.setProperty("Webdriver.chrome.driver", "resources//chromedriver.exe");
    }

    public static ChromeOptions enableChromeIncognito() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--incognito");
        DesiredCapabilities d = new DesiredCapabilities();
        d.setCapability(ChromeOptions.CAPABILITY, option);
        return option.merge(d);
    }

    public static void setTimeout(WebDriver d, int ms) {
        //This timeout is used to specify the amount of time the driver
        // should wait while searching for an element if it is not immediately present.
        d.manage().timeouts().implicitlyWait(Duration.ofMillis(ms));

        //This is used to set the amount of time the WebDriver must wait for an asynchronous
        // script to finish execution before throwing an error.
        d.manage().timeouts().scriptTimeout(Duration.ofMillis(ms));

        //This sets the time to wait for a page to load completely before throwing an error.
        // If the timeout is negative, page loads can be indefinite.
        d.manage().timeouts().pageLoadTimeout(Duration.ofMillis(ms));
    }

    public static void scrollAndClick(WebDriver driver, By cssSelector) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(cssSelector));
        driver.findElement(cssSelector).click();
    }

    public  static void ElementClick(WebDriver driver , By CssSelector) {
     WebElement el = driver.findElement(CssSelector);
     el.click();


    }


    public static void scrollToElement(WebDriver driver, By cssSelector) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(cssSelector));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void zoomInout(WebDriver driver, double percentageInDecimal) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = ' " + percentageInDecimal + " ' ");
    }

    public static Properties initializeProperties() {

        if (prop != null)
            return prop;
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("demoQa.properties");
            prop.load(ip);
        } catch (Exception e) {
            System.out.println("Exception occurred during config initialization. " + e.getMessage());
            Reporter.log("Failed to load properties file. Error: " + e.getMessage());
        }
        return prop;
    }

    public static WebDriver getWebDriver() {
        if (prop == null)
            initializeProperties();
        String browser = prop.getProperty("browser");
        System.out.println(browser);
        WebDriver driver;
        if (browser == null || browser.equalsIgnoreCase("Chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browser.equalsIgnoreCase("headless")) {
            System.out.println("Setting headless demoQa.properties");
            var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1280,800");
            chromeOptions.addArguments("--allow-insecure-localhost");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = WebDriverManager.safaridriver().create();
        } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("mozilla")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = WebDriverManager.edgedriver().create();
        } else {
            driver = WebDriverManager.chromedriver().create();
        }
        return driver;
    }

    public static void WebDriverWait(WebDriver driver, By elementSelector , int ms){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ms));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementSelector));
    }

    public static void scrollWaitAndClickUsingJs(WebDriver driver, By elementSelector, int ms) {
        //1. Scroll using JS
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementSelector));

        //2.Wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ms));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementSelector));

        String currentZoom = (String) ((JavascriptExecutor) driver).executeScript("return document.body.style.zoom;");

        //3. Zoom out to 50%
        DriverUtils.zoomOutToPercentage(driver, .50);

        //4. click using JS
        DriverUtils.clickUsingJS(driver, element);

        //5. Set old Zoom percentage
        if (currentZoom.length() > 0) {
            ((JavascriptExecutor) driver).executeScript("document.body.style.zoom=" + currentZoom);
        }
    }

    public static void clickUsingJS(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }

    public static void zoomOutToPercentage(WebDriver driver, double percentage) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '" + percentage + "'");

    }
}