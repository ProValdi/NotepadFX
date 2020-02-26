package enums;

public enum Menus {
    FILE("File"),
    EDIT("Edit"),
    VIEW("View"),
    SETTINGS("Settings");

    private String name;
    Menus(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}