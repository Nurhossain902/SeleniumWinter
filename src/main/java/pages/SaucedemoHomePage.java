package pages;

import org.openqa.selenium.By;

public class SaucedemoHomePage {
    public String sauceUrl = "https://www.saucedemo.com/";
    public String inventoryUrl = "https://www.saucedemo.com/inventory.html";
    public By userName = new By.ByCssSelector("#user-name");
    public By password = new By.ByCssSelector("#password");
    public By login = new By.ByCssSelector("#login-button");
    public By productsLocator = new By.ByXPath("//button[text()='Products']");



}
