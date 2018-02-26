package hw3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import static enums.LoginPageEnum.DRIVER;
import static java.lang.System.setProperty;

public class Base {

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setProperties() {
        setProperty("chromedriver", DRIVER.text);
    }
}