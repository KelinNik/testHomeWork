package enums;

public enum  LoginPageEnum {

    DRIVER("C:\\Users\\Nikolai_Kelin\\IdeaProjects\\testHomeWork\\chromedriver.exe"),
    MAIN_PAGE_ADDRESS("https://jdi-framework.github.io/tests"),
    INDEX_PAGE("Index Page"),
    NAME("epam"),
    PASSWORD("1234"),
    USER_NAME("piter chailovskii");

    public String text;

    LoginPageEnum(String text) {
        this.text = text;
    }
}
