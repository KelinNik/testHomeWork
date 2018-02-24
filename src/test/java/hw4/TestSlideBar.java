package hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import hw4.pages.DatePage;
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
public class TestSlideBar {
    private IndexPage indexPage;
    private DatePage datePage;
    private User user;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        indexPage = Selenide.page(IndexPage.class);
        datePage = Selenide.page(DatePage.class);
        user = new User();
    }

    @Test
    public void testSlideBar() {

        //1 Open Browser
        indexPage.openPage();

        //2 Perform login
        indexPage.performLogin(user);

        //3 Click on "Service" subcategory in the header and -> Date
        indexPage.checkDropdownMenu();

        //4 Open Date page
        datePage.openPage();

        datePage.checkSlidersPositions("20", "100");

        //5 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datePage.moveSlidersAtNewPositions(-60, 0);
        datePage.checkSlidersPositions("0", "100");

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datePage.moveSlidersAtNewPositions(-20, -300);
        datePage.checkSlidersPositions("0", "0");

        //7 Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position.
        datePage.moveSlidersAtNewPositions(300, 400);
        datePage.checkSlidersPositions("100", "100");

        //8 Using drag-and-drop set Range sliders.
        datePage.moveSlidersAtNewPositions(-194, -84);
        datePage.checkSlidersPositions("0", "70");

        datePage.closeBrowser();
    }
}
