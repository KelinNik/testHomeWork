package hw4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class Base {

    @BeforeSuite(alwaysRun = true)
    public void setProperties() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
}
