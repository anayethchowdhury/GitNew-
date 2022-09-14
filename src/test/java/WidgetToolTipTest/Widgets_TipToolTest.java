package WidgetToolTipTest;

import Utils.DriverUtils;
import Pages.Widget_TipToolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Widgets_TipToolTest {
    WebDriver driver;

Widget_TipToolPage widgetTipToolPage = new Widget_TipToolPage();
    @BeforeClass
    void setup() {
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get(widgetTipToolPage.pageUrl);
    }

    @Test
    void Tooltip() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(widgetTipToolPage.hoverboxSelector));
        action.click().build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(widgetTipToolPage.toolTip));
        Assert.assertTrue(element.getText().contains("You hovered over the text field"));
    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }
}
