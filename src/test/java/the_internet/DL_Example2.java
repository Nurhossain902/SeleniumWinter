package the_internet;

import Utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DL_Example2 {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = DriverUtil.getWebDriver();
//        driver.get( "http://the-internet.herokuapp.com/dynamic_loading/2" );
        driver.get( "https://demoqa.com/progress-bar" );
    }

    @Test
    void progressBar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By startButton = new By.ByCssSelector("#startStopButton");
        driver.findElement( startButton ).click();
        By outputResult = new By.ByXPath("//div[contains(text(),'100%')]");

        wait.until( ExpectedConditions.visibilityOfElementLocated( outputResult ));

        WebElement el = driver.findElement(outputResult);
        String result = el.getText();
        Assert.assertEquals( result, "100%");
    }



//    @Test
//    void dynamicWaitTest(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        By startButton = new By.ByCssSelector("#start button");
//        driver.findElement( startButton ).click();
//
//        By outputText = new By.ByCssSelector("#finish");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated ( outputText ));
//
//        WebElement el = driver.findElement(outputText);
//
//        String output = el.getText();
//
//        Assert.assertEquals(output, "Hello World!");
//
//    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }



}
