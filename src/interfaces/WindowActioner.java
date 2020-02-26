package interfaces;

import enums.Items;
import javafx.scene.control.MenuItem;

public interface WindowActioner {
    void saveAction(MenuItem item, Items enumItem);
    void openAction(MenuItem item, Items enumItem);
    void newFileCreating(MenuItem item, Items enumItem);
    void exitAction(MenuItem item, Items enumItem);
}
