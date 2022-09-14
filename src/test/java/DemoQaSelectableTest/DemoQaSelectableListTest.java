package DemoQaSelectableTest;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQaSelectableListTest {
    static WebDriver driver;


    @BeforeClass
    void setup() {
      //  utils.setChromePath();

        driver = DriverUtils.getWebDriver();
        DriverUtils.setTimeout(driver, 10000);
        driver.get("https://demoqa.com");
        DriverUtils.scrollAndClick(driver, By.cssSelector(".top-card:nth-child(5)"));
        driver.findElement(By.cssSelector(".top-card:nth-child(5)")).click();
        DriverUtils.scrollAndClick(driver, By.cssSelector(".element-group:nth-child(5) #item-1"));
        driver.findElement(By.cssSelector(".element-group:nth-child(5) #item-1")).click();
        DriverUtils.scrollAndClick(driver, By.cssSelector("#demo-tab-list"));
    }
    @Test(priority = 2)
    void testsinglelist() throws InterruptedException {
        testListItem("#verticalListContainer > li:nth-child(1)");
        testListItem("#verticalListContainer > li:nth-child(1)");
        testListItem("#verticalListContainer > li:nth-child(1)");
        testListItem("#verticalListContainer > li:nth-child(4)");

    }

    void testListItem ( String selector) throws InterruptedException {
        //boxone
        WebElement list = driver.findElement(By.cssSelector(selector));
        list.click();
        Thread.sleep(1000);
        Assert.assertTrue(list.getAttribute("class").contains("active"));
        list.click();
        Thread.sleep(1000);
        Assert.assertFalse(list.getAttribute("class").contains("active"));
        Thread.sleep(1000);
    }
    @AfterClass
    void wrapup(){
        driver.quit();
    }
}
