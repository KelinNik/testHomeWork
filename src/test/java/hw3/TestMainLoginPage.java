package hw3;

import enums.MainPageEnum;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static enums.FirstPageEnum.MAIN_PAGE_HEAD_TEXT;
import static enums.FirstPageEnum.MAIN_PAGE_TEXT_BELLOW_HEADER;
import static enums.LoginPageEnum.*;

public class TestMainLoginPage extends Base {

    private MainPage mainPage;

    @BeforeClass(alwaysRun = true)
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPage() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    //9 Close Browser
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

    @Test
    public void loginTest() {

        //1 Open test site by URL
        mainPage.openPage(driver);

        //2 Assert Browser title
        mainPage.checkPageTitle(driver, INDEX_PAGE.text);

        //3 Perform login
        mainPage.login(NAME.text, PASSWORD.text);

        //4 Assert User name in the left-top side of screen that user is loggined
        mainPage.getUserName(USER_NAME.text);

        //5 Assert Browser title
        mainPage.checkPageTitle(driver, INDEX_PAGE.text);

        //6 Assert that there are 4 images on the Home Page and they are displayed
        mainPage.checkImagesIsDisplayed();

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
        mainPage.checkTextIsDisplayed(MainPageEnum.values());
        mainPage.checkAccordanceTextAndEnum();

        //8 Assert that there are the main header and the text below it on the Home Page
        mainPage.checkMainContent();
        mainPage.checkMainTitle(MAIN_PAGE_HEAD_TEXT);
        mainPage.checkMainTextInPage(MAIN_PAGE_TEXT_BELLOW_HEADER);
    }
}
