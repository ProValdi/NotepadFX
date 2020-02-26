package enums;

public enum Items {
    NEW("New", "CTRL+N", ItemsTypes.MENUITEM, 1),
    OPEN("Open", "CTRL+O", ItemsTypes.MENUITEM, 2),
    SAVE("Save", "CTRL+S", ItemsTypes.MENUITEM, 3),
    EXIT("Exit", "CTRL+ESC", ItemsTypes.MENUITEM, 4),
    SEPARATOR(ItemsTypes.SEPARATOR, 0),
    BAD(ItemsTypes.DEBUG, 0);

    private String name;
    private String hotKey;
    private ItemsTypes type;
    private int number;

    Items(ItemsTypes type, int number) {
        this.type = type;
    }

    Items(String name, String hotKey, ItemsTypes type, int number) {
        this(type, number);
        this.name = name;
        this.hotKey = hotKey;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getHotKey() {
        return hotKey;
    }

    public ItemsTypes getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }
}