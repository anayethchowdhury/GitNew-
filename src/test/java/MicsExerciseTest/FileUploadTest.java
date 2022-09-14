package MicsExerciseTest;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;


    @BeforeClass
    void setup(){
        driver = DriverUtils.getWebDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
    }
    @Test
    void fileUploadTest() throws InterruptedException {
        WebElement fileupload = driver.findElement(By.cssSelector("#file-upload"));
        String abosulatepath = DriverUtils.initializeProperties().getProperty("projectPath") + "/rosources/nike.png";
        fileupload.sendKeys(abosulatepath);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#file-submit")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#uploaded-files")).getText().contains("nike.png"));
        Thread.sleep(3000);
    }
    @AfterClass
    void wrapup(){
        driver.quit();
    }
}
