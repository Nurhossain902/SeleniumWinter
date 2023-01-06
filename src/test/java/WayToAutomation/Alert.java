package WayToAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Alert {
    WebDriver driver;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");

//        //clicking on the alert menu
//        By alertMenuLocator = new By.ByCssSelector(".linkbox:nth-child(6) a");
//        WebElement alertMenu = driver.findElement(alertMenuLocator);
//        alertMenu.click();
//
//        //switch to second tab
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
    }

    @Test
    void test_Alert() throws InterruptedException {
        By alertButtonLocator = new By.ByCssSelector(".row:first-child button");
        WebElement alertButton = driver.findElement(alertButtonLocator);
        alertButton.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    @Test
    void test_Alert2() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By alertButtonLocator = new By.ByCssSelector("#timerAlertButton");
        WebElement alertButton = driver.findElement(alertButtonLocator);
        alertButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    @Test
    void test_Alert3() throws InterruptedException {
        Thread.sleep(3000);
        By alertButtonLocator = new By.ByCssSelector("#confirmButton");
        WebElement alertButton = driver.findElement(alertButtonLocator);

        //click ok
        alertButton.click();
        driver.switchTo().alert().accept();

        //confirm is the right show up
        By resultLocator = new By.ByCssSelector("#confirmResult");
        WebElement resultEl = driver.findElement(resultLocator);
        String result = resultEl.getText();
        Assert.assertTrue(result.contains("Ok"));

        //clicking Cancel
        alertButton.click();
        driver.switchTo().alert().dismiss();

        //confirm is the right show up
        result = resultEl.getText();
        Assert.assertTrue(result.contains("Cancel"));

    }

    @Test
    void test_Alert4() throws InterruptedException {
        By prompLocator = new By.ByCssSelector("#promtButton");
        WebElement promtButton = driver.findElement(prompLocator);

        //Negative Test
        promtButton.click();
        driver.switchTo().alert().sendKeys("123B5V7");
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();

        By resultSelector = new By.ByCssSelector("#promtResult");
        Assert.assertThrows(()-> driver.findElement(resultSelector));

        //pasitive Test
        promtButton.click();
        driver.switchTo().alert().sendKeys("123B5V7");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        WebElement resultEl = driver.findElement(resultSelector);
        String resultText = resultEl.getText();
        Assert.assertTrue(resultText.contains("123B5V7"));

    }


    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
