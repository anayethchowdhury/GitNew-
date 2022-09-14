package DemoQaBookStoreTest;

import Utils.DriverUtils;
import Pages.BookStoreRegiPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookStoreRegistrationTest {
    WebDriver driver;
    BookStoreRegiPage bookStoreRegiPage = new BookStoreRegiPage();

    @BeforeClass
    void setup() {
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get(bookStoreRegiPage.url);
    }

    @Test
    void registerTest() throws InterruptedException {
        driver.findElement(bookStoreRegiPage.register);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(bookStoreRegiPage.register));
        driver.findElement(bookStoreRegiPage.register).click();
        Thread.sleep(3000);

        WebElement firstname = driver.findElement(bookStoreRegiPage.firstname);
        Assert.assertTrue(firstname.getAttribute("class").contains("invalid"));
        Thread.sleep(1000);

        WebElement lastname = driver.findElement(bookStoreRegiPage.lastname);
        Assert.assertTrue(lastname.getAttribute("class").contains("invalid"));
        Thread.sleep(1000);

        WebElement username = driver.findElement(bookStoreRegiPage.username);
        Assert.assertTrue(username.getAttribute("class").contains("invalid"));
        Thread.sleep(1000);

        WebElement password = driver.findElement(bookStoreRegiPage.password);
        Assert.assertTrue(password.getAttribute("class").contains("invalid"));

    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }
}
