package Pages;

import org.openqa.selenium.By;

public class DemoQaFrontPage extends BasePageElementsPage {
    public String pageURL = "https://demoqa.com/";

    public By element = new By.ByCssSelector(".top-card:nth-child(1)");

    public By forms = new By.ByCssSelector(".top-card:nth-child(2)");

    public By alertsframe = new By.ByCssSelector(".top-card:nth-child(3)");

    public By widgets = new By.ByCssSelector(".top-card:nth-child(4)");

    public By interection = new By.ByCssSelector(".top-card:nth-child(5)");

    public By bookstore = new By.ByCssSelector(".top-card:nth-child(6)");


}
