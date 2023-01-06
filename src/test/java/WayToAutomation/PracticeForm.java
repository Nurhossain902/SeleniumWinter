package WayToAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeForm {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://demoqa.com/automation-practice-form");

    }

    @Test
    void name(){
        By firstName = new By.ByCssSelector("#userName-wrapper :nth-child(2) input");
        WebElement firstNameEl = driver.findElement(firstName);
        firstNameEl.sendKeys("David");

        By lastName = new By.ByCssSelector("#userName-wrapper :nth-child(4) input");
        WebElement lastNameEl = driver.findElement(lastName);
        lastNameEl.sendKeys("Warner");
    }

    @Test
    void email(){
        By email = new By.ByCssSelector("#userEmail-wrapper :nth-child(2) input");
        WebElement emailEl = driver.findElement(email);
        emailEl.sendKeys("davidwarner@gmail.com");
    }

    @Test
    void selectGender(){
        By gender = new By.ByCssSelector("#genterWrapper :nth-child(1) label");
        WebElement genderEl = driver.findElement(gender);
        genderEl.click();
    }

    @Test
    void mobile(){
        By number = new By.ByCssSelector("#userNumber-wrapper :nth-child(2) input ");
        WebElement numberEl = driver.findElement(number);
        numberEl.sendKeys("7197259999");
    }

    @Test
    void dateOfBirth(){
        By yearLocator = new By.ByCssSelector(".react-datepicker__year-select");
        Select yearSelect = new Select(driver.findElement(yearLocator));
        yearSelect.selectByVisibleText("1995");

        By monthLocator = new By.ByCssSelector(".react-datepicker__month-select");
        Select monthSElect = new Select(driver.findElement(monthLocator));
        monthSElect.selectByVisibleText("june");

        By dateLocator = new By.ByXPath("//div[contains(text()'21')]");
        WebElement dateEl = driver.findElement(dateLocator);
        dateEl.click();
    }

    @Test
    void subjects() throws InterruptedException {
        By selectSubjects = new By.ByCssSelector("#subjectsWrapper :nth-child(2) input");
        WebElement selectSubjectsEl = driver.findElement(selectSubjects);
        selectSubjectsEl.sendKeys("Computer");
        Thread.sleep(4000);
        selectSubjectsEl.sendKeys(Keys.TAB);
    }

    @Test
    void  hobbies(){
        By selectHobbies = new By.ByCssSelector("#hobbiesWrapper :nth-child(2) :nth-child(2) label");
        WebElement hobbiesEl = driver.findElement(selectHobbies);
        hobbiesEl.click();

    }

    @Test
    void chooseFile(){
        By picture = new By.ByCssSelector("#userForm :nth-child(8) :nth-child(2) [class='form-file']");
        WebElement pictureEl = driver.findElement(picture);
        pictureEl.sendKeys("C:\\Users\\Shobo\\IdeaProjects\\SeleniumWinter\\img.png");
    }

    @Test
    void currentAddress(){
        By address = new By.ByCssSelector("#currentAddress-wrapper :nth-child(2) textarea");
        WebElement addressEl = driver.findElement(address);
        addressEl.sendKeys("123 Main st, buffalo, NY, 10245");
    }

    @Test
    void stateAndCity(){
        By selectState = new By.ByCssSelector("#stateCity-wrapper :nth-child(2) #state");
        Select stateEl = new Select(driver.findElement(selectState));
        stateEl.selectByVisibleText("NCR");

        By selectCity = new By.ByCssSelector("#stateCity-wrapper :nth-child(3) #city");
        Select cityEl = new Select(driver.findElement(selectCity));
        cityEl.selectByVisibleText("Delhi");
    }

    @Test
    void  submit(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.body.style.zoom=.70");

        By submit = new By.ByCssSelector("#submit");
        WebElement submitEl = driver.findElement(submit);
        submitEl.click();
    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(5000);
//        driver.quit();
    }
}
