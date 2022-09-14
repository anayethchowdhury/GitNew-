package Pages;

import org.openqa.selenium.By;

public class RadioPage extends ElementPage {

    public String  pageUrl = ("https://demoqa.com/radio-button");

    public By yesRadio = new By.ByCssSelector("#yesRadio");

    public By noRadio = new By.ByCssSelector("#noRadio");

    public By impressive = new By.ByCssSelector("#impressiveRadio");

    public By textSuccess  = new By.ByCssSelector(".text-success");
}
