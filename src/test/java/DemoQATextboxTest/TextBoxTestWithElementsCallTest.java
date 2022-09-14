package DemoQATextboxTest;

import Utils.DriverUtils;
import Pages.ElementPage;
import Pages.TextBoxPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

public class TextBoxTestWithElementsCallTest {
    static WebDriver driver;

    ElementPage elementPage = new ElementPage();
    TextBoxPage textBoxPage= new TextBoxPage();

    @BeforeClass
    void getready(){
        driver = DriverUtils.getWebDriver();
        driver.get(elementPage.pageURL);
    }
    @Test
    void textbox() throws InterruptedException {
        Faker faker = new Faker(new Locale("en-US"));
       // DriverUtils.scrollAndClick(driver,elementPage.textBox);  //using the new method from driverutils scroll and click

        driver.findElement(elementPage.textBox).click();

        String fullname =faker.name().fullName();
        driver.findElement(textBoxPage.fullName).sendKeys(fullname);
        driver.findElement(textBoxPage.useremail).sendKeys(faker.name().username() + ("@gmail.com"));
        driver.findElement(textBoxPage.currentAddress).sendKeys(faker.address().fullAddress());
        driver.findElement(textBoxPage.permanentAddress).sendKeys(faker.address().fullAddress());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(textBoxPage.textBoxSubmit));
        driver.findElement(textBoxPage.textBoxSubmit).click();
        String submitteditem = driver.findElement(textBoxPage.textBoxSubmittedItem).getText();
        Thread.sleep(1000);
        Assert.assertFalse(submitteditem.isEmpty());
        Thread.sleep(1000);
    }

    @AfterClass
        void wrapup() throws InterruptedException {
        driver.quit();
    }
}
