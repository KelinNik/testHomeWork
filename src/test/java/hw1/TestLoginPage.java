package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//Create a new test for checking access, finding images and some text
public class TestLoginPage {

    private WebDriver driver;

    // driver initialization
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //9 Close Browser
    @AfterTest
    public void closeEverything() {
        driver.close();
    }

    @Test
    public void loginPageTest() {

        //1 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //3 Perform login
        driver.findElement(By.className("navbar-right")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.className("btn-login")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement profileName = driver.findElement(By.className("profile-photo"));
        assertTrue(profileName.isDisplayed());
        Assert.assertEquals(profileName.getText().toLowerCase(), "piter chailovskii");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //6 Assert that there are 4 images on the Home Page and they are displayed
        driver.findElement(By.className("icon-practise")).isDisplayed();
        driver.findElement(By.className("icon-custom")).isDisplayed();
        driver.findElement(By.className("icon-multi")).isDisplayed();
        driver.findElement(By.className("icon-base")).isDisplayed();

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> text = driver.findElements(By.className("benefit-txt"));
        assertEquals(text.size(), 4);
        for (WebElement aText : text) {
            assertTrue(aText.isDisplayed());
        }
        assertEquals((text.get(0).getText()), "To include good practices" + "\n" + "and ideas from successful" + "\n" + "EPAM projec");
        assertEquals((text.get(1).getText()), "To be flexible and" + "\n" + "customizable");
        assertEquals((text.get(2).getText()), "To be multiplatform");
        assertEquals((text.get(3).getText()), "Already have good base" + "\n" + "(about 20 internal and" + "\n" + "some external projects)," + "\n" + "wish to get more…");

        //8 Assert that there are the main header and the text below it on the Home Page
        WebElement mainTitle = driver.findElement(By.className("main-title"));
        assertEquals(mainTitle.getText(), ("EPAM FRAMEWORK WISHES…"));
        WebElement mainText = driver.findElement(By.className("main-txt"));
        assertTrue(mainText.getText().contains("LOREM IPSUM"));
    }
}