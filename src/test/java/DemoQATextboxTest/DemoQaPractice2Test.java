package DemoQATextboxTest;

import Utils.DriverUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

public class DemoQaPractice2Test {
    static WebDriver driver;

    Faker f = new Faker(new Locale("en-US"));

    @BeforeClass
    void setup() {
     driver = DriverUtils.getWebDriver();
        driver.findElement(By.cssSelector(".element-group:nth-child(1) #item-0")).click();
    }


    @Test (priority = 5)
    void findElements() throws InterruptedException {
        WebElement el = driver.findElement(By.cssSelector("#item-0 > span"));
        el.click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#userName")).sendKeys(f.name().username());
        Thread.sleep(1000);

        String email = f.name().username() + f.number().randomDigit() +"@gmail.com";
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(email);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#currentAddress")).sendKeys(f.address().fullAddress());
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys(f.address().fullAddress());
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#submit")).click();
        Thread.sleep(1000);

        WebElement resultbox = driver.findElement(By.cssSelector("#output > div"));
      //  Thread.sleep(1000);

        Assert.assertTrue(resultbox.getText().contains("Address"));

        Thread.sleep(1000);
    }

    @AfterClass
        void quit () {
        driver.quit();
        }
    }
