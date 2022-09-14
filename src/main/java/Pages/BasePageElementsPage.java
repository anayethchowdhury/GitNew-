package Pages;

import org.openqa.selenium.By;

public class BasePageElementsPage {

    public String pageURL = ("https://demoqa.com/text-box");

    public By logo = new By.ByCssSelector("#app img");

    public By footer = new By.ByCssSelector(" #app > footer > span");
}
