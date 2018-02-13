package enums;

public enum FirstPageEnum {
    MAIN_PAGE_HEAD_TEXT("EPAM FRAMEWORK WISHES"),
    MAIN_PAGE_TEXT_BELLOW_HEADER("LOREM IPSUM");

    public String text;

    FirstPageEnum(String text) {
        this.text = text;
    }
}
