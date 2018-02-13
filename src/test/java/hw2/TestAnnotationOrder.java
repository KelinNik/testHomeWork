package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestAnnotationOrder {

    private WebDriver driver;

    @BeforeSuite
    public void something() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    // driver initialization
    @BeforeTest
    public void preparation() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void checkDriver() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @AfterMethod
    public void getPageTitle() {
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void executionTime() {
        System.out.println(System.currentTimeMillis());
    }

    //  Close browser
    @AfterSuite
    public void closeEverything() {
        driver.close();
    }

    //checking access for site
    @Test
    public void test1() {

        //open site
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //full screen
        driver.manage().window().maximize();

        //checking accordance Title for expect title
        assertEquals(driver.getTitle(), "Index Page");

        //checking perform filling login and password
        WebElement element = driver.findElement(By.className("navbar-right"));
        element.click();
        WebElement login = driver.findElement(By.id("Login"));
        login.sendKeys("epam");
        WebElement pass = driver.findElement(By.id("Password"));
        pass.sendKeys("1234");
        WebElement enter = driver.findElement(By.className("btn-login"));
        enter.click();


        //checking user name on page
        WebElement element1 = driver.findElement(By.className("profile-photo"));
        assertTrue(element1.isDisplayed());
        Assert.assertEquals(element1.getText().toLowerCase(), "piter chailovskii");

        //checking accordance Title for expect title
        assertEquals(driver.getTitle(), "Index Page");

        //checking existence of 4 images
        WebElement image1 = driver.findElement(By.className("icon-practise"));
        WebElement image2 = driver.findElement(By.className("icon-custom"));
        WebElement image3 = driver.findElement(By.className("icon-multi"));
        WebElement image4 = driver.findElement(By.className("icon-base"));
        assertTrue(image1.isDisplayed());
        assertTrue(image2.isDisplayed());
        assertTrue(image3.isDisplayed());
        assertTrue(image4.isDisplayed());

        //checking text under images
        List<WebElement> text = driver.findElements(By.className("benefit-txt"));
        assertEquals(text.size(), 4);
        for (WebElement aText : text) {
            assertTrue(aText.isDisplayed());
        }
        assertEquals((text.get(0).getText()), "To include good practices" + "\n" + "and ideas from successful" + "\n" + "EPAM projec");
        assertEquals((text.get(1).getText()), "To be flexible and" + "\n" + "customizable");
        assertEquals((text.get(2).getText()), "To be multiplatform");
        assertEquals((text.get(3).getText()), "Already have good base" + "\n" + "(about 20 internal and" + "\n" + "some external projects)," + "\n" + "wish to get more…");

        //checking text on main page
        WebElement element2 = driver.findElement(By.className("main-content"));
        assertTrue(element2.getText().contains("EPAM FRAMEWORK WISHES"));
        assertTrue(element2.getText().contains("LOREM IPSUM"));
    }
}

