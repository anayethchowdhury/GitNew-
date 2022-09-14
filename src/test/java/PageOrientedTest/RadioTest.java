package PageOrientedTest;

import Utils.DriverUtils;
import Pages.RadioPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioTest {
    WebDriver driver;
    RadioPage radio = new RadioPage();

    @BeforeClass
    void setUp() {
        driver = DriverUtils.getWebDriver();
        driver.get(radio.pageUrl);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void yesButton() {
        WebElement yes = driver.findElement(radio.yesRadio);
        if (yes.isEnabled()) {
            yes.click();
            Assert.assertTrue(driver.findElement(radio.textSuccess).getText().contains("Yes"));
        }
    }

    @Test(priority = 2)
    void impressive() {
        WebElement impressive = driver.findElement(radio.impressive);
        if (impressive.isEnabled()) {
            impressive.click();
            Assert.assertTrue(driver.findElement(radio.textSuccess).getText().equals("Impressive"));
        }
    }

    @Test(priority = 3)
    void no() {

        WebElement no = driver.findElement(radio.noRadio);
        Assert.assertFalse(no.isEnabled());
    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }
}

