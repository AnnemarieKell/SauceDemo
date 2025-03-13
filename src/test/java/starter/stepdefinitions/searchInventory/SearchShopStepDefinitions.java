package starter.stepdefinitions.searchInventory;


import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;


import starter.Pages.headerPage;
import starter.tasks.Inventory.CheckPrice;
import starter.tasks.Inventory.SelectItem;

import static starter.tasks.Inventory.CheckPrice.checkhighestPrice;
import static starter.tasks.Inventory.CheckPrice.checklowestPrice;
import static starter.tasks.Inventory.PutIteminCart.putHighestPricedItemInCart;
import static starter.tasks.Inventory.PutIteminCart.verifyRemoveButton;

public class SearchShopStepDefinitions {

    @When("{actor} looks up the highest price item")
    public void checkingPrice(Actor actor) {

        actor.wasAbleTo(checkhighestPrice());

    }

    @When("{actor} looks up the {string} price item")
    public void checkingPrice(Actor actor, String priced) {

        if (priced.equals("highest")) {
            actor.wasAbleTo(checkhighestPrice());
        } else if(priced.equals("lowest")) {
            actor.wasAbleTo(checklowestPrice());
        }

    }

    @When("{actor} looks up the lowest price item")
    public void he_looks_up_the_lowest_price_item(Actor actor) {

        actor.wasAbleTo(checklowestPrice());

    }
    @When("{actor} puts this item in the cart")
    public void he_puts_this_item_in_the_cart(Actor actor) {

        actor.attemptsTo(putHighestPricedItemInCart(actor));

    }
    @When("{actor} selects the highest priced item")
    public void he_selects_item(Actor actor) {

        actor.attemptsTo(SelectItem.SelectItem(actor));

    }
    @When("{actor} selects the highest priced item through title link")
    public void he_selects_item_through_title_link(Actor actor) {

        actor.attemptsTo(SelectItem.SelectItemTitleLink(actor));

    }
    @When("{actor} can see that the itemcounter in the cart icon displays {string}")
    public void he_verify_in_cart(Actor actor, String number) {

        actor.attemptsTo(verifyRemoveButton(actor));
        actor.attemptsTo(Ensure.that(headerPage.cartItemNumbers()).isEqualToIgnoringCase(number));

    }

}
