package starter.tasks.Inventory;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import starter.Pages.inventory.inventory;

public class PutIteminCart {

    public static Performable putPricedItemInCart(Actor actor) {

        return Task.where( "puts item in cart ",
                inventory::putPricedItemInCart);
    }

    public static Performable verifyItemCountinCartWentup(Actor actor) {

        return Task.where( "puts item in cart ",
                inventory::putPricedItemInCart);

    }

    public static Performable verifyRemoveButton(Actor actor) {

        return Task.where( "he can see the remove button ",
                inventory::checkifIteminCart);

    }

}
