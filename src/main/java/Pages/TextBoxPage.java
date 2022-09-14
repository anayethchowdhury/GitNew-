package Pages;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage  {

    public String url ="https://demoqa.com/text-box";

    public By fullName = new By.ByCssSelector("#userName");

    public By useremail = new By.ByCssSelector("#userEmail");

    public By currentAddress = new By.ByCssSelector("#currentAddress");

    public By permanentAddress = new By.ByCssSelector("#permanentAddress");

    public By textBoxSubmit = new By.ByCssSelector("#submit");

    public By textBoxSubmittedItem = new By.ByCssSelector(".border");
    public  By output = new By.ByCssSelector("#output");

    public void populateFormAndClick(WebDriver driver, String name, String email, String currAdd, String perAdd){

        driver.findElement(fullName).sendKeys(name);
        driver.findElement(useremail).sendKeys(email);
        driver.findElement(currentAddress).sendKeys(currAdd);
        driver.findElement(permanentAddress).sendKeys(perAdd);
        //driver.findElement(submitButton).click();
        DriverUtils.scrollAndClick(driver,textBoxSubmit);


    }



}
