package hw4.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatePage {

    private static final String DATA_PAGE = "https://jdi-framework.github.io/tests/page4.htm";

    @FindBy(css = ".m-l8")
    private SelenideElement menuService;

    @FindBy(css = "[role = 'menu']+li")
    private List<SelenideElement> menuList;

    @FindBy(css = ".uui-slider a:first-child")
    private SelenideElement leftSlider;

    @FindBy(css = ".uui-slider a:last-child")
    private SelenideElement rightSlider;

    @Step("Open page")
    public void openPage() {
        Selenide.open(DATA_PAGE);
    }

    @Step("Move slide bar at new position")
    public void moveSlidersAtNewPositions(int leftValue, int rightValue) {

        Actions actions = new Actions(getWebDriver());

        if (rightSlider.$("span").getText().equals("0")) {
            actions.dragAndDropBy(rightSlider, rightValue, 0).build().perform();
            actions.dragAndDropBy(leftSlider, leftValue, 0).build().perform();
        } else {
            actions.dragAndDropBy(leftSlider, leftValue, 0).build().perform();
            actions.dragAndDropBy(rightSlider, rightValue, 0).build().perform();
        }
    }

    @Step("Check slider's position")
    public void checkSlidersPositions(String leftPos, String rightPos) {

        leftSlider.$("span").shouldHave(exactText(leftPos));
        rightSlider.$("span").shouldHave(exactText(rightPos));
    }

    @Step("Close browser")
    public void closeBrowser() {
        close();
    }
}
