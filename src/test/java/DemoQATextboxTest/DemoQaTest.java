package DemoQATextboxTest;

import Utils.DriverUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

public class DemoQaTest {
    static WebDriver driver;


    @BeforeClass
    void setup() {
      driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        DriverUtils.setTimeout(driver, 5000);
        driver.get("https://demoqa.com");
    }

    @Test(priority = 1)
    void testTitle() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(), "ToolsQA");
        Thread.sleep(3000);
    }


    @Test(priority = 2)
    void testLogo() throws InterruptedException {

        WebElement el = driver.findElement(By.cssSelector("#app > header > a > img"));
        el.getText();
        Assert.assertTrue(el.isDisplayed());
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    void validateFooter() throws InterruptedException {
        WebElement el = driver.findElement(By.cssSelector(" #app > footer > span"));
        String footerText = el.getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("TOOLSQA.COM"));
        // Thread.sleep(3000);
    }

    @Test(priority = 5)
    void TextbookCheck() throws InterruptedException {
        Faker f = new Faker(new Locale("en-US"));
        String fullName = f.name().fullName();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)")));
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".element-group:nth-child(1) #item-0")).click();
        driver.findElement(By.cssSelector("#userName")).sendKeys(fullName);
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(f.name().username() + "@gmail.com");
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys(f.address().fullAddress());
        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys(f.address().fullAddress());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#submit")));
        driver.findElement(By.cssSelector("#submit")).click();
        String submittedItems = driver.findElement(By.cssSelector(".border")).getText();
        Thread.sleep(5000);
        Assert.assertFalse(submittedItems.isEmpty());
        Assert.assertTrue(submittedItems.contains(fullName));

    }


    @AfterClass
    void wrapUp() {
        driver.quit();
    }
}