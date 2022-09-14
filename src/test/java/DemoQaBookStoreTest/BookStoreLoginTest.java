package DemoQaBookStoreTest;

import Utils.DriverUtils;
import Pages.BookStoreLoginPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BookStoreLoginTest {
    WebDriver driver;

    BookStoreLoginPage bookStoreLoginPage = new BookStoreLoginPage();

    @BeforeClass
    void setup() {
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get(bookStoreLoginPage.url);
    }

    @Test (priority = 1)
    void LoginTest() throws InterruptedException {

        String path = DriverUtils.initializeProperties().getProperty("username");
        String pass = DriverUtils.initializeProperties().getProperty("password");
        driver.findElement(bookStoreLoginPage.username).sendKeys(path);
        driver.findElement(bookStoreLoginPage.password).sendKeys(pass);
        driver.findElement(bookStoreLoginPage.logIn).click();
        Thread.sleep(1000);
        WebElement profile = driver.findElement(bookStoreLoginPage.Profile);
        Assert.assertTrue(profile.isDisplayed());

    }

    @Test (priority = 2)
    void bookCollection() throws InterruptedException {
        DriverUtils.scrollAndClick(driver, bookStoreLoginPage.bookstore);
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(bookStoreLoginPage.booksname);
        Faker faker =  new Faker();
        int number = faker.random().nextInt(0,elements.size()-1);
        DriverUtils.scrollToElement(driver, elements.get(number));
        elements.get(number).click();
        Thread.sleep(2000);
        DriverUtils.scrollAndClick(driver, bookStoreLoginPage.collectionapp);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        driver.get(bookStoreLoginPage.profileurl);
        elements = driver.findElements(bookStoreLoginPage.booksname);
        Assert.assertEquals(elements.size(),1);
        Thread.sleep(2000);
    }

    @Test (priority = 3)
    void lastBook() throws InterruptedException {
        driver.get(bookStoreLoginPage.bookurl);
        List<WebElement> elements = driver.findElements(bookStoreLoginPage.booksname);
        DriverUtils.scrollToElement(driver, elements.get(elements.size() - 1));
        elements.get(elements.size() - 1).click();
        Thread.sleep(3000);
       // DriverUtils.scrollAndClick(driver, bookStoreLoginPage.collectionapp);
        DriverUtils.scrollWaitAndClickUsingJs(driver,bookStoreLoginPage.collectionapp,2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        Thread.sleep(2000);
        driver.get(bookStoreLoginPage.profileurl);
        elements = driver.findElements(bookStoreLoginPage.booksname);
        Assert.assertEquals(elements.size(),2);
        Thread.sleep(2000);
    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }
}
