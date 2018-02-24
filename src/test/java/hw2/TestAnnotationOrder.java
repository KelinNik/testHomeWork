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
    public void testTitle() {
        driver.manage().window().maximize();
        driver.navigate().to("http://www.epam.com");
        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }
}

