package hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import hw4.pages.DifferentPage;
import hw4.pages.IndexPage;
import hw4.pages.User;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Listeners(AllureAttachmentListener.class)
public class TestOfFunctionality {

    private IndexPage indexPage;
    private DifferentPage differentPage;
    private User user;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        indexPage = Selenide.page(IndexPage.class);
        differentPage = Selenide.page(DifferentPage.class);
        user = new User();
    }

    @Test
    public void functionalTest() {

        //1 Open test site by URL
        indexPage.openPage();

        //2 Perform login
        indexPage.performLogin(user);

        //3 Assert User name in the right-top side of screen that user is loggined
        indexPage.checkUserName(user);

        //4 Check interface on Home page, it contains all needed elements.
        indexPage.checkImagesExistence();
        indexPage.checkTextUnderImages();
        indexPage.checkTextAccordance();

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkDropdownMenu();

        //6 Open through the header menu Service -> Different Elements Page
        differentPage.openPage();

        //7 Check interface on Service page, it contains all needed elements.
        differentPage.checkAllNeededElements();

        //8 Select and assert checkboxes
        differentPage.checkBoxIsSelected();

        //9 Select radio
        differentPage.checkSelectionRadioButton();

        //10 Select in dropdown
        differentPage.checkSelectionDropdown(TextInLog.text);

        //11 Check in logs section selected values and status (true|false)
        differentPage.checkValuesInLogs(TextInLog.text);

        //12 Unselect and assert checkboxes
        differentPage.checkBoxIsNOTSelected();

        //13 Check in logs section unselected values and status (true|false)
        differentPage.checkValuesInLogs(TextInLog2.text);

        differentPage.closeBrowser();
    }
}
