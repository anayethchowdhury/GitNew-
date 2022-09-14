package Pages;

import org.openqa.selenium.By;

public class BookStoreRegiPage {
    public  String url = "https://demoqa.com/register";
    public By register = new By.ByCssSelector("#register");
    public By firstname = new By.ByCssSelector("#firstname");
    public By lastname = new By.ByCssSelector("#lastname");
    public By username = new By.ByCssSelector("#userName");
    public By password = new By.ByCssSelector("#password");

}
