package MicsExerciseTest;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicDownloadLink {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = DriverUtils.getWebDriver();
        driver.get("http://the-internet.herokuapp.com/download");
    }

    @Test
    void  download(){
       List <WebElement> element = driver.findElements(By.cssSelector(".example a"));
       element.get(32).click();
       element.get(0).click();

    }
    @AfterClass
    void wrapup(){

    }
}
