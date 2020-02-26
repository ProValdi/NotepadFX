package windowSetup;

import enums.Items;
import enums.Menus;
import javafx.scene.control.*;

public class NotepadFXItems extends Menu {

    private static final int magicConstant = 10; // magic constant :)
    private Menus name;
    private int[] indexes = new int[magicConstant];

    public NotepadFXItems(Menus name) {
        this.name = name;
        setText(name.getName());
    }

    public void addItem(Items item) {

        switch(item.getType()) {
            case MENUITEM:
                getItems().add(new MenuItem(item.getName()));       break;
            case SEPARATOR:
                getItems().add(new SeparatorMenuItem());            break;
            case CHECKITEM:
                getItems().add(new CheckMenuItem(item.getName()));  break;
            case RADIOITEM:
                getItems().add(new RadioMenuItem(item.getName()));  break;
            default: throw new UnsupportedOperationException();

        }

    }

    public void addWindowActioner(NotepadFXWindow window) {
        NotepadFXMenuItemAction itemAction = new NotepadFXMenuItemAction(window);

        itemAction.saveAction(getItem(Items.SAVE), Items.SAVE);
        itemAction.openAction(getItem(Items.OPEN), Items.OPEN);
        itemAction.newFileCreating(getItem(Items.NEW), Items.NEW);
        itemAction.exitAction(getItem(Items.EXIT), Items.EXIT);
    }

    public void addAllItems(Items... items) {
        int i = 0;
        for(Items item : items) {
            indexes[item.getNumber()] = i++;
            addItem(item);
        }
    }

    public Menus getName() {
        return name;
    }

    private MenuItem getItem(Items item) {
        return getItems().get(indexes[item.getNumber()]);
    }

}

