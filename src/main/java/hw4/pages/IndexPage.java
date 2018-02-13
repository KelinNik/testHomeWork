package hw4.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.MainPageEnum;
import enums.MenuListEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static enums.FirstPageEnum.MAIN_PAGE_HEAD_TEXT;
import static enums.FirstPageEnum.MAIN_PAGE_TEXT_BELLOW_HEADER;

public class IndexPage {

    private static final String ADDRESS = "https://jdi-framework.github.io/tests";

    @FindBy(css = ".profile-photo")
    private SelenideElement rightTopAngle;

    @FindBy(css = ".benefits")
    private List<SelenideElement> elementList;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> elementText;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainTextInPage;

    @FindBy(css = ".m-l8")
    private SelenideElement menuService;

    @FindBy(css = "[role = 'menu']+li")
    private List<SelenideElement> menuList;

    @Step("Open page")
    public void openPage() {
        Selenide.open(ADDRESS);
    }

    @Step("Login")
    public void performLogin(User user) {
        $(".uui-profile-menu").click();
        $("#Login").sendKeys(user.getName());
        $("#Password").sendKeys(user.getPassword());
        $(".btn-login").click();
    }

    @Step("Check user name")
    public void checkUserName(User user) {
        rightTopAngle.isDisplayed();
        rightTopAngle.should(matchesText("PITER CHAILOVSKII"));
    }

    @Step("Check Images Existence")
    public void checkImagesExistence() {
        for (SelenideElement el : elementList) {
            el.isDisplayed();
        }
    }

    @Step("Check text under images")
    public void checkTextUnderImages() {
        for (int i = 0; i < elementText.size(); i++) {
            elementText.get(i).shouldHave(text(MainPageEnum.values()[i].toString()));
        }
    }

    @Step("Check main page texts, header and text bellow")
    public void checkTextAccordance() {
        mainTitle.should(Condition.visible);
        mainTextInPage.should(Condition.visible);
        mainTitle.should(matchesText(MAIN_PAGE_HEAD_TEXT.text));
        mainTextInPage.should(matchesText(MAIN_PAGE_TEXT_BELLOW_HEADER.text));
    }

    @Step("Check dropDown Menu")
    public void checkDropdownMenu() {
        menuService.exists();
        menuService.click();

        for (int i = 0; i < menuList.size(); i++) {
            menuList.get(i).shouldHave(text(MenuListEnum.values()[i].text));
        }
    }
}