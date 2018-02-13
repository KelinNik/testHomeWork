package enums;

public enum MenuListEnum {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLES("Tables With Wages"),
    DIFFERENT_ELEMENTS("Different Elements");

    public String text;

    MenuListEnum(String text) {
        this.text = text;
    }
}
