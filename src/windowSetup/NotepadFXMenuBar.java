package windowSetup;

import enums.Items;
import enums.Menus;
import javafx.scene.control.*;

import java.util.*;

public class NotepadFXMenuBar extends MenuBar {

    private List<NotepadFXItems> menus;

    public NotepadFXMenuBar(NotepadFXWindow window) {

        NotepadFXItems fileMenu = new NotepadFXItems(Menus.FILE);
        fileMenu.addAllItems(Items.NEW, Items.OPEN, Items.SAVE, Items.SEPARATOR, Items.EXIT);
        fileMenu.addWindowActioner(window);

        NotepadFXItems editMenu = new NotepadFXItems(Menus.EDIT);

        NotepadFXItems viewMenu = new NotepadFXItems(Menus.VIEW);

        NotepadFXItems settingsMenu = new NotepadFXItems(Menus.SETTINGS);

        menus = new ArrayList<>();
        menus.add(fileMenu);
        menus.add(editMenu);
        menus.add(viewMenu);
        menus.add(settingsMenu);

        getMenus().addAll(menus);

    }


}

