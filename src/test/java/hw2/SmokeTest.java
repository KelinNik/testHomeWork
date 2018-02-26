package hw2;

import enums.MainPageEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static enums.MainPageEnum.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTest {
    private WebDriver driver;

    private List<WebElement> text;

    private List<WebElement> image;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        text = driver.findElements(By.className("benefit-txt"));
        image = driver.findElements(By.className("benefit-icon"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @DataProvider(parallel = true)
    public Object[][] textDataBenefitClass() {
        return new Object[][]{
                {PRACTISE},
                {CUSTOM},
                {MULTI},
                {BASE}
        };
    }

    @Test(dataProvider = "textDataBenefitClass", groups = {"smoke"})
    public void smokeTest1(MainPageEnum anEnum) {

        assertEquals(text.get(anEnum.ordinal()).getText().replaceAll("\n", " "), anEnum.toString());
        assertTrue(image.get(anEnum.ordinal()).isDisplayed());
    }
}