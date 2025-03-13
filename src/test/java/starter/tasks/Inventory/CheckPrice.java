package starter.tasks.Inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import starter.Pages.inventory.inventory;



public class CheckPrice {
    public static Performable checkhighestPrice() {

        return Task.where( "looks at the highest price",
                CheckPrice::checkHighestPrice);
    }

    public static Performable checklowestPrice() {

        return Task.where( "looks at the lowest price",
                CheckPrice::checkLowestPrice);
    }

    private static void checkHighestPrice(Actor actor) {

         actor.sawAsThe(getPrice("highest"));

    }

    private static void checkLowestPrice(Actor actor) {

        actor.sawAsThe(getPrice("lowest"));

    }


    private static String getPrice(String priced) {
        inventory inv = new inventory();
        int num = priced.equals("lowest") ? inv.sortPrices().size() - 1 : 0;
        String price = inv.sortPrices().get(num).toString();
        Serenity.recordReportData().withTitle(priced +" Price is ").andContents(price);
        inventory.price = price;
        return price;

    }


}
