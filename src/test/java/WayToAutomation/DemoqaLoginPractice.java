package WayToAutomation;

import Utils.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookStorePage;
import pages.DemoQAHomePage;
public class DemoqaLoginPractice {
   WebDriver driver;
   DemoQAHomePage homePage;
   BookStorePage bookStorePage;

    @BeforeClass
    void setUp() {
        driver = DriverUtil.getWebDriver();
        homePage = new DemoQAHomePage();
        bookStorePage = new BookStorePage();
        driver.get(homePage.url);
        driver.manage().window().maximize();

    }
    @Test
    void nevigateToLoginPage() throws InterruptedException {
        DriverUtil.clickUsingJS(driver.findElement(homePage.bookStore));
        Assert.assertEquals(driver.getCurrentUrl(), bookStorePage.bookStoreUrl);
        Thread.sleep(2000);

        driver.findElement(bookStorePage.loginSubmenuLocator).click();
        Assert.assertEquals(driver.getCurrentUrl(), bookStorePage.loginUrl);
        Thread.sleep(1000);

        driver.findElement(bookStorePage.userNameLocator).sendKeys("authorwiese");
        driver.findElement(bookStorePage.passwordLocator).sendKeys("Author@123");
        driver.findElement(bookStorePage.loginButtonLocator).click();
        Thread.sleep(2000);
        String userNameFromPage = driver.findElement(bookStorePage.usernameLabelLocator).getText();
        Assert.assertEquals(userNameFromPage, "authorwiese");
        Thread.sleep(2000);

        driver.findElement(bookStorePage.selectBook).click();
        Thread.sleep(2000);
//        driver.findElement(bookStorePage.addBook).click();
        DriverUtil.clickUsingJS(bookStorePage.addBook);
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
//        driver.findElement(bookStorePage.profile).click();
        DriverUtil.clickUsingJS(bookStorePage.profile);
        Thread.sleep(2000);
        String bookName = driver.findElement(bookStorePage.bookNameLocator).getText();
        Assert.assertEquals(bookName,"Git Pocket Guide");

        Thread.sleep(2000);
        driver.findElement(bookStorePage.deleteBook).click();
        Thread.sleep(4000);
        driver.findElement(bookStorePage.clickOk).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

    }


    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
