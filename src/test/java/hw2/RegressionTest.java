package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegressionTest {
    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //1 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    @AfterTest(alwaysRun = true)
    public void closeEverything() {
        driver.close();
    }


    @Test(groups = {"regression"})
    public void regressionTest1() {

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");
    }


    @Test(groups = {"regression"})
    public void regressionTest2() {
        driver.findElement(By.className("navbar-right")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.className("btn-login")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement profileName = driver.findElement(By.className("profile-photo"));
        assertTrue(profileName.isDisplayed());
        Assert.assertEquals(profileName.getText().toLowerCase(), "piter chailovskii");
    }
}

//
//    @DataProvider(parallel = true)
//    public Object[][] dataForTest() {
//        return new Object[][]{
//                {"regression ", "test"}
//        };
//    }

//    @Test(dataProvider = "dataForTest", groups = {"regression"})
//    public void regressionTest1(String i, String s) {
//        System.out.println(i + s);
//    }

//    @Test(groups = {"regression"})
//    public void regressionTest2() {
//        System.out.println("regression test");
//    }
