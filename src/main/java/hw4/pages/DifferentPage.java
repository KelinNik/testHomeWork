package hw4.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.CheckBoxEnum;
import enums.RadioButtonsEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static org.testng.AssertJUnit.assertTrue;

public class DifferentPage {
    private final static String DIFFERENT_PAGE = "https://jdi-framework.github.io/tests/page8.htm";

    @FindBy(css = ".main-content-hg .checkbox-row .label-checkbox")
    private List<SelenideElement> checkBoxElements;

    @FindBy(css = ".main-content-hg .checkbox-row .label-radio")
    private List<SelenideElement> checkBoxLabelElements;

    @FindBy(css = ".colors .uui-form-element")
    private SelenideElement dropdownColors;

    @FindBy(css = ".logs")
    private SelenideElement logsList;

    @Step("Open page")
    public void openPage() {
        Selenide.open(DIFFERENT_PAGE);
    }

    @Step("Check that there are all elements")
    public void checkAllNeededElements() {
        $(".main-content-hg").isDisplayed();
        for (int i = 0; i < checkBoxElements.size(); i++) {
            checkBoxElements.get(i).isDisplayed();
            checkBoxElements.get(i).shouldHave(text(CheckBoxEnum.values()[i].text));
            checkBoxLabelElements.get(i).shouldHave(text(RadioButtonsEnum.values()[i].text));
        }
        dropdownColors.isDisplayed();
        $("[name='Default Button']").isDisplayed();
        $("[value='Button']").isDisplayed();
    }


    @Step("Select 1 and 3 checkBox")
    public void checkBoxIsSelected() {
        checkBoxElements.get(0).isDisplayed();
        checkBoxElements.get(2).isDisplayed();
        checkBoxElements.get(0).click();
        checkBoxElements.get(0).$("input[type='checkbox']").shouldBe(Condition.checked);
        checkBoxElements.get(2).click();
        checkBoxElements.get(2).$("input[type='checkbox']").shouldBe(Condition.checked);
    }

    @Step("Select radioButton")
    public void checkSelectionRadioButton() {
        checkBoxLabelElements.get(3).click();
        checkBoxLabelElements.get(3).should(Condition.enabled);
    }

    @Step("Check dropdown is selected")
    public void checkSelectionDropdown(String[] text) {
        dropdownColors.click();
        dropdownColors.isDisplayed();
        dropdownColors.selectOption(text[0]);
    }

    @Step("Check logs")
    public void checkValuesInLogs(String[] text) {
        List<SelenideElement> logListRow = logsList.$$("li");
        for (int i = 0; i < text.length - 1; i++) {
            assertTrue(logListRow.get(i).getText().contains(text[i]));
            logListRow.get(i).should(Condition.matchesText(text[i]));
        }
    }

    @Step("Check checkBox is not selected")
    public void checkBoxIsNOTSelected() {
        checkBoxElements.get(0).click();
        checkBoxElements.get(0).$("input[type='checkbox']").shouldNotBe(Condition.checked);
        checkBoxElements.get(2).click();
        checkBoxElements.get(2).$("input[type='checkbox']").shouldNotBe(Condition.checked);
    }

    @Step("Close browser")
    public void closeBrowser() {
        close();
    }
}