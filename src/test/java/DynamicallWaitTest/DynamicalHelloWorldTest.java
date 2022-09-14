package DynamicallWaitTest;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicalHelloWorldTest {
    static WebDriver driver;

    @BeforeClass
    void setup() throws InterruptedException {

        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        DriverUtils.setTimeout(driver, 10000);
        driver.get("http://the-internet.herokuapp.com/dynamic_loading");
        Thread.sleep(2000);
    }

    @Test
    void TestExampleone() throws InterruptedException {
        DriverUtils.scrollAndClick(driver, By.cssSelector(".example a[href='/dynamic_loading/1'"));
        Thread.sleep(1000);
        DriverUtils.scrollAndClick(driver, By.cssSelector(".example button"));
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector("div #finish")));
        Thread.sleep(1000);
        WebElement helloworld = driver.findElement(By.cssSelector("div #finish"));

        Assert.assertTrue(helloworld.getText().contains("Hello World!"));
        Thread.sleep(1000);
    }

    @Test
    void voidTestExampleTwo() throws InterruptedException {

        driver.get("http://the-internet.herokuapp.com/dynamic_loading");
        DriverUtils.scrollAndClick(driver, By.cssSelector(".example a[href='/dynamic_loading/2"));
        Thread.sleep(1000);
        DriverUtils.scrollAndClick(driver, By.cssSelector(".example button"));
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("div #finish")));
        Thread.sleep(1000);
        WebElement helloworld = driver.findElement(By.cssSelector("div #finish"));
        Assert.assertTrue(helloworld.getText().contains("Hello World!"));
        Thread.sleep(1000);

    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }
}
