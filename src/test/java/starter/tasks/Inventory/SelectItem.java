package starter.tasks.Inventory;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import starter.Pages.inventory.inventory;

public class SelectItem {
    public static Performable SelectItem(Actor actor) {

        return Task.where( "he selects the item by clicking on the picture ",
                inventory::selectItemthroughPictureLink);
    }
    public static Performable SelectItemTitleLink(Actor actor) {

        return Task.where( "he selects the item by clicking on the title",
                inventory::selectItemthroughTitleLink);
    }
}
