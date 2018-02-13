package enums;

public enum MainPageEnum {

    PRACTISE("To include good practices and ideas from successful EPAM projec"),
    CUSTOM("To be flexible and customizable"),
    MULTI("To be multiplatform"),
    BASE("Already have good base (about 20 internal and some external projects), wish to get more…");

    private String text;

    MainPageEnum(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}
