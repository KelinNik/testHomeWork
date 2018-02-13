package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTest {

    @DataProvider(parallel = true)
    public Object[][] testData() {
        return new Object[][]{
                {"smoke", " test"}
        };
    }

    @Test(dataProvider = "testData", groups = {"smoke"})
    public void smokeTest1(String i, String s) {
        System.out.println(i + s);
    }

    @Test(groups = {"smoke"})
    public void smokeTest2() {
        System.out.println("smoke test");
    }
}
