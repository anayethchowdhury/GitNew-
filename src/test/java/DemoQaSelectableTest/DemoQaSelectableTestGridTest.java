package DemoQaSelectableTest;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQaSelectableTestGridTest {

    static WebDriver driver;


    @BeforeClass
    void setup() {
        //utils.setChromePath();
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        DriverUtils.setTimeout(driver, 10000);
        driver.get("https://demoqa.com");

        DriverUtils.scrollAndClick(driver, By.cssSelector(".top-card:nth-child(5)")); //interaction
        DriverUtils.scrollAndClick(driver, By.cssSelector(".element-group:nth-child(5) #item-1"));
    }

    @Test(priority = 1)
    void testsinglegrid() throws InterruptedException {
        DriverUtils.scrollAndClick(driver, By.cssSelector("#demo-tab-grid"));
        testGridItem("#row1 li:nth-child(1)");
        testGridItem("#row1 li:nth-child(2)");
        testGridItem("#row1 li:nth-child(3)");

        testGridItem("#row2 li:nth-child(1)");
        testGridItem("#row2 li:nth-child(2)");
        testGridItem("#row2 li:nth-child(3)");

        testGridItem("#row3 li:nth-child(1)");
        testGridItem("#row3 li:nth-child(2)");
        testGridItem("#row3 li:nth-child(3)");
    }

    void testGridItem(String selector) throws InterruptedException {
        //boxone
        WebElement box = driver.findElement(By.cssSelector(selector));
        box.click();
        Thread.sleep(500);
        Assert.assertTrue(box.getAttribute("class").contains("active"));
        box.click();
        Thread.sleep(500);
        Assert.assertFalse(box.getAttribute("class").contains("active"));
        Thread.sleep(500);
    }

    @Test(priority = 2)
    void testsinglelist() throws InterruptedException {
        DriverUtils.scrollAndClick(driver, By.cssSelector("#demo-tab-list"));
        driver.findElement(By.cssSelector("#demo-tab-list")).click();
        testListItem("#verticalListContainer > li:nth-child(1)");
        testListItem("#verticalListContainer > li:nth-child(2)");
        testListItem("#verticalListContainer > li:nth-child(3)");
        testListItem("#verticalListContainer > li:nth-child(4)");

    }

    void testListItem(String selector) throws InterruptedException {
        //boxone
        WebElement list = driver.findElement(By.cssSelector(selector));
        list.click();
        Thread.sleep(500);
        Assert.assertTrue(list.getAttribute("class").contains("active"));
        list.click();
        Thread.sleep(500);
        Assert.assertFalse(list.getAttribute("class").contains("active"));
        Thread.sleep(500);
    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }

}
