package WayToAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class RegistrationFormTest {
    WebDriver driver;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");
    }

    @Test
    void completeRegistration() throws InterruptedException {
        By regLlink = new By.ByCssSelector(".linkbox:nth-child(5) a");
        WebElement regLinkElement = driver.findElement(regLlink);
        Thread.sleep(3000);
        regLinkElement.click();
        //steps to get all opened tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        String secondTabAddress = tabs.get(1);
        //navigate to tab #2
        driver.switchTo().window(secondTabAddress );

        //Locator for first name
        By firstName = new By.ByCssSelector("fieldset:first-child p:first-child input");
        WebElement firstNameEl = driver.findElement(firstName);
        firstNameEl.sendKeys("Donald");

        By lastName = new By.ByCssSelector("fieldset:first-child p:last-child input");
        WebElement lastNameEl = driver.findElement(lastName);
        lastNameEl.sendKeys("Trump");

        By maritalStatus = new By.ByCssSelector("fieldset:nth-child(2) .radio_wrap  input");
        WebElement maritalStatusEl = driver.findElement(maritalStatus);
        maritalStatusEl.click();

        By hubby = new By.ByCssSelector("fieldset:nth-child(3) :nth-child(3) input");
        WebElement hubbyEl = driver.findElement(hubby);
        hubbyEl.click();

        By country = new By.ByCssSelector("fieldset:nth-child(4) select");
        Select countrySelect = new Select(driver.findElement(country));
        countrySelect.selectByVisibleText("India");

        By month = new By.ByCssSelector(".time_feild:nth-child(2) select");
        Select monthSelect = new Select(driver.findElement(month));
        monthSelect.selectByVisibleText("1");

        By day = new By.ByCssSelector(".time_feild:nth-child(3) select");
        Select daySelect = new Select(driver.findElement(day));
        daySelect.selectByVisibleText("1");

        By year = new By.ByCssSelector(".time_feild:nth-child(4) select");
        Select yearSelect = new Select(driver.findElement(year));
        yearSelect.selectByVisibleText("2014");

        By phoneNumber = new By.ByCssSelector("fieldset [name='phone']");
        WebElement numberEl = driver.findElement(phoneNumber);
        numberEl.sendKeys("3473276378");

        By username = new By.ByCssSelector("fieldset [name='username']");
        WebElement usernameEl = driver.findElement(username);
        usernameEl.sendKeys("Donaldtpm");

        By email = new By.ByCssSelector("fieldset [name='email']");
        WebElement emailEl = driver.findElement(email);
        emailEl.sendKeys("Donald123@gmail.com");

        By profilePicture = new By.ByCssSelector("fieldset [type='file']");
        WebElement pictureEl = driver.findElement(profilePicture);
        pictureEl.sendKeys("C:\\Users\\Shobo\\IdeaProjects\\SeleniumWinter\\img.png");

        By aboutYourself = new By.ByCssSelector("fieldset [rows='5']");
        WebElement aboutYourselfEl = driver.findElement(aboutYourself);
        aboutYourselfEl.sendKeys("Let's make America great again");

        By password = new By.ByCssSelector("fieldset [name='password']");
        WebElement passwordEl = driver.findElement(password);
        passwordEl.sendKeys("Donald123");

        By confirmPassword = new By.ByCssSelector("fieldset [name='c_password']");
        WebElement confirmPasswordEl = driver.findElement(confirmPassword);
        confirmPasswordEl.sendKeys("Donald123");

//        By submit = new By.ByCssSelector("fieldset [value='submit']");
//        WebElement submitEl = driver.findElement(submit);
//        submitEl.click();


    }


    @AfterClass
    void wrapUp(){
//        driver.quit();
    }
}
