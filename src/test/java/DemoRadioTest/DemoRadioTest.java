package DemoRadioTest;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoRadioTest {
    static WebDriver driver;

    @BeforeClass

    void setup() {

        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        DriverUtils.setTimeout(driver, 10000);
        driver.get("https://demoqa.com");

        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)")).click();

        driver.findElement(By.cssSelector(".element-group:nth-child(1) #item-2")).click();
        // driver.findElement(By.cssSelector("#yesRadio")).click();
        // driver.findElement(By.cssSelector("#impressiveRadio")).click();
    }

    @Test(priority = 1)
    void yesRadio() {
        WebElement yes = driver.findElement(By.cssSelector("#yesRadio+label"));

        if (yes.isEnabled()) {
            yes.click();
            Assert.assertTrue(driver.findElement(By.cssSelector(".text-success")).getText().equals("Yes"));
        }

    }


    @Test
    void ImpressiveRadio() {
        //  WebElement Impressive = driver.findElement(By.cssSelector("#impressiveRadio")).click();
        // WebElement Impressive = driver.findElement(By.cssSelector("#impressiveRadio")).click();

        WebElement impressive = driver.findElement(By.cssSelector("#impressiveRadio+label"));
        if (impressive.isEnabled()) {
            impressive.click();
            Assert.assertTrue(driver.findElement(By.cssSelector(".text-success")).getText().equals("Impressive"));
        }
    }

    @Test
    void noradio() {
        WebElement noRadio = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadio.isEnabled());


    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }


}



