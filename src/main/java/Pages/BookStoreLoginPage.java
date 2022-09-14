package Pages;

import org.openqa.selenium.By;

public class BookStoreLoginPage {
    public String url = "https://demoqa.com/login";
    public String bookurl = "https://demoqa.com/books";
    public String profileurl = "https://demoqa.com/profile";

    public By username = new By.ByCssSelector("#userName");
    public By password = new By.ByCssSelector("#password");
    public By logIn = new By.ByCssSelector("#login");
    public By Profile = new By.ByCssSelector(".pattern-backgound.playgound-header");

    public By bookstore = new By.ByCssSelector(".element-group:nth-child(6) #item-2");
    public By collectionapp = new By.ByCssSelector(".profile-wrapper .fullButtonWrap .text-right.fullButton");

    public By booksname = new By.ByCssSelector(".mr-2");
}
