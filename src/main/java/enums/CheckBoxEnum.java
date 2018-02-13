package enums;

public enum CheckBoxEnum {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String text;

    CheckBoxEnum(String text) {
        this.text = text;
    }
}
