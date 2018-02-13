package hw3;

import enums.FirstPageEnum;
import enums.MainPageEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static enums.LoginPageEnum.MAIN_PAGE_ADDRESS;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MainPage {

    private WebDriver driver;

    @FindBy(css = ".navbar-right")
    private WebElement loginMenuForm;

    @FindBy(css = "#Login")
    private WebElement loginButton;

    @FindBy(css = "#Password")
    private WebElement passwordButton;

    @FindBy(css = ".btn-login")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo")
    private WebElement userName;

    @FindBy(css = ".benefits")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTexts;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainTextInPage;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage() {
        driver.navigate().to(MAIN_PAGE_ADDRESS.text);
    }

    public void login(String name, String password) {

        loginMenuForm.click();
        loginButton.sendKeys(name);
        passwordButton.sendKeys(password);
        submitButton.click();
    }

    public void checkPageTitle(WebDriver driver, String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void getUserName(String name) {
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText().toLowerCase(), name);
    }

    public void checkImagesIsDisplayed() {
        for (WebElement capture : images) {
            assertTrue(capture.isDisplayed());
        }
    }

    public void checkTextIsDisplayed() {
        for (WebElement element : benefitTexts) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkAccordanceTextAndEnum() {
        for (int i = 0; i < images.size(); i++) {
            assertEquals(benefitTexts.get(i).getText().replaceAll("\n", " "), MainPageEnum.values()[i].toString());
        }
    }

    public void checkMainContent() {
        assertTrue(mainTitle.isDisplayed());
        assertTrue(mainTextInPage.isDisplayed());
    }

    public void checkMainTitle(FirstPageEnum text) {
        assertTrue(mainTitle.getText().contains(text.text));
    }
    public void checkMainTextInPage(FirstPageEnum text) {
        assertTrue(mainTextInPage.getText().contains(text.text));
    }

}