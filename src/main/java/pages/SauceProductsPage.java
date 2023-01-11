package pages;

import org.openqa.selenium.By;

public class SauceProductsPage {
    public By sauceLabsBackpack = new By.ByCssSelector("#item_4_title_link");
    public By addToCart= new By.ByCssSelector("#add-to-cart-sauce-labs-backpack");
    public By gotoShopingCart= new By.ByCssSelector(".shopping_cart_link");
    public By remove = new By.ByXPath("//button[text()='Remove']");
    public By continueShopping= new By.ByCssSelector("#continue-shopping");

}
