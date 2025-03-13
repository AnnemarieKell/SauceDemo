package starter.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;


public class headerPage  {
    public static final Target numberofItems = Target.the("cart numberofItems").located(By.className("shopping_cart_badge"));
    public static Question<String> cartItemNumbers() {
        WaitUntil.the(numberofItems, WebElementStateMatchers.isVisible());
        return actor -> numberofItems.resolveFor(actor).getText();
    }

}
