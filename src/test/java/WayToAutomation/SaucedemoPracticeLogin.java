package WayToAutomation;

import Utils.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SauceProductsPage;
import pages.SaucedemoHomePage;

public class SaucedemoPracticeLogin {
    WebDriver driver;
    SaucedemoHomePage homePageLogin;
    SauceProductsPage products;

    @BeforeClass
    void setUp(){
        driver = DriverUtil.getWebDriver();
        homePageLogin = new SaucedemoHomePage();
        products = new SauceProductsPage();
        driver.get(homePageLogin.sauceUrl);
        driver.manage().window().maximize();
    }

    @Test
    void navigateToProductsPage() throws InterruptedException {
//        Thread.sleep(1000);
        driver.findElement(homePageLogin.userName).sendKeys("standard_user");
        driver.findElement(homePageLogin.password).sendKeys("secret_sauce");
        driver.findElement(homePageLogin.login).click();
        Assert.assertEquals(driver.getCurrentUrl(),homePageLogin.inventoryUrl);
//        String result = driver.findElement(homePageLogin.productsLocator);
    }
    @Test
    void shopping() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(products.sauceLabsBackpack).click();
        Thread.sleep(1000);
        driver.findElement(products.addToCart).click();
        Thread.sleep(1000);
        driver.findElement(products.gotoShopingCart).click();
        Thread.sleep(1000);
        driver.findElement(products.remove).click();
        Thread.sleep(1000);
        driver.findElement(products.continueShopping).click();

    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
