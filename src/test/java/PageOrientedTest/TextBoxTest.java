package PageOrientedTest;

import Utils.DriverUtils;
import Pages.TextBoxPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxTest {
    WebDriver driver;
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeClass
    void setup() {
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get(textBoxPage.url);
    }

    @Test
    void textbox() throws InterruptedException {

        Faker faker = new Faker();
        String name = faker.name().name();
        String email = faker.name().username() + "@gmail.com";
        String currAdd = faker.address().fullAddress();
        String perAdd = faker.address().fullAddress();
        textBoxPage.populateFormAndClick(driver, name, email, currAdd, perAdd);
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(textBoxPage.output).getText().contains(name));
    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }
}
