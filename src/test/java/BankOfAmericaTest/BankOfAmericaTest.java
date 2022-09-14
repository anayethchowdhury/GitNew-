package BankOfAmericaTest;

import Utils.BaseMethod;
import Utils.DriverUtils;
import Pages.BankOfAmericaPage;
import Utils.ExcelUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class BankOfAmericaTest extends BaseMethod {
    WebDriver driver;
    BankOfAmericaPage bankOfAmericaPage = new BankOfAmericaPage();
    static final String EXCEL_FILE_PATH = System.getProperty("user.dir") + "/resources/Excel/Mock_Data.xlsx";

    @BeforeClass
    void setup() throws InterruptedException {
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
      //  driver.get(bankOfAmericaPage.url);
    }


    @DataProvider(name = "loadFromdata")
    public static Object[][] dataload() throws Exception {
        return ExcelUtils.getTableArray(EXCEL_FILE_PATH, "Small Data Set");
    }

    @Test(dataProvider = "loadFromdata")
    void testForm(double id, String firstname, String name, String gender, String dob, String snn, String phone, String email) throws Exception {
        driver.get(bankOfAmericaPage.url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bankOfAmericaPage.apply));
        element.click();
        Thread.sleep(3000);
        DriverUtils.scrollToElement(driver, bankOfAmericaPage.firstname);
        Thread.sleep(1000);
        driver.findElement(bankOfAmericaPage.firstname).sendKeys(firstname);
        Thread.sleep(1000);
        driver.findElement(bankOfAmericaPage.lastname).sendKeys(name);
        Thread.sleep(1000);
        DriverUtils.scrollToElement(driver, bankOfAmericaPage.address);
        Thread.sleep(1000);
        Faker faker = new Faker(new Locale("en-US"));
        driver.findElement(bankOfAmericaPage.address).sendKeys(faker.address().buildingNumber() + "newton st");
        Thread.sleep(1000);
        driver.findElement(bankOfAmericaPage.city).sendKeys(faker.address().city());
        Thread.sleep(1000);

        driver.findElement(bankOfAmericaPage.state).sendKeys(faker.address().state());

        String state = driver.findElement(bankOfAmericaPage.state).getAttribute("data-val");
        System.out.println(state);
        Thread.sleep(1000);
        driver.findElement(bankOfAmericaPage.zipcode).sendKeys(faker.address().zipCodeByState(state));
        System.out.println(faker.address().zipCodeByState(state).substring(0, 4));
        Thread.sleep(1000);
        System.out.println(phone);
        driver.findElement(bankOfAmericaPage.phonenumber).sendKeys(phone);
        Thread.sleep(1000);
        DriverUtils.clickUsingJS(driver, driver.findElement(bankOfAmericaPage.mobile));
        driver.findElement(bankOfAmericaPage.email).sendKeys(email);
        Thread.sleep(1000);
        DriverUtils.clickUsingJS(driver, driver.findElement(bankOfAmericaPage.saveandcontinue));
        Thread.sleep(15000);

         DriverUtils.clickUsingJS(driver, driver.findElement(bankOfAmericaPage.Citizenyes));
      //  DriverUtils.scrollAndClick(driver, bankOfAmericaPage.Citizenyes);
        Thread.sleep(5000);
        driver.findElement(bankOfAmericaPage.socialsc).sendKeys(snn);
        Thread.sleep(1000);
        DriverUtils.clickUsingJS(driver, driver.findElement(bankOfAmericaPage.duelcitizen));
        Thread.sleep(5000);
        selectByVisibleText(driver.findElement(bankOfAmericaPage.countryresidense), "United States");
        Thread.sleep(1000);
        driver.findElement(bankOfAmericaPage.DateofBirth).sendKeys(dob);

        DriverUtils.clickUsingJS(driver, driver.findElement(bankOfAmericaPage.saveandcontinue));
        Thread.sleep(15000);

        selectByVisibleText(driver.findElement(bankOfAmericaPage.employmentstatus), "Employed" );
        Thread.sleep(1000);
        selectByVisibleText(driver.findElement(bankOfAmericaPage.occupation), "Programmer" );
        Thread.sleep(1000);

        driver.findElement(bankOfAmericaPage.annualincome).sendKeys("100000"); // sendkays.faker.nummerify ("10000"); another way of putting the annual income..
        Thread.sleep(1000);
        selectByVisibleText(driver.findElement(bankOfAmericaPage.sourceincome), "Employment");
        Thread.sleep(1000);
        driver.findElement(bankOfAmericaPage.motnthlypayment).sendKeys("1000");
        Thread.sleep(1000);

        DriverUtils.clickUsingJS(driver, driver.findElement(bankOfAmericaPage.saveandcontinue));
        Thread.sleep(15000);

        DriverUtils.clickUsingJS(driver, driver.findElement(bankOfAmericaPage.checkbox));
        Thread.sleep(1000);

        DriverUtils.clickUsingJS(driver, driver.findElement(bankOfAmericaPage.saveandcontinue));
        Thread.sleep(15000);

        String reviewInformation = driver.findElement(bankOfAmericaPage.review).getText();
        Assert.assertTrue(reviewInformation.contains("Review your information"));
        Thread.sleep(3000);

        driver.navigate().refresh();


    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }
}
