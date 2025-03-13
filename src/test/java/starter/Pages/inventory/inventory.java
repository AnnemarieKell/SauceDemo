package starter.Pages.inventory;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.saucedemo.com/v1/inventory.html")
public class inventory extends PageObject {
   public static String price;
    @Managed
    WebDriver driver = getDriver();
    static Target Button_next_Price = Target.the("button next to the Price {0}").locatedBy("(//*[text()[contains(.,'{0}')]])/following-sibling::button");
    static Target Button_Select_Item = Target.the("Picture of Price of {0}").locatedBy("(//*[text()[contains(.,'{0}')]])/parent::*/parent::*//a");

    public List<Double> sortPrices() {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<Double> mylist = findAll(".inventory_item_price").stream()
                .map(element -> {
                    String priceText = (String) jsExecutor.executeScript(
                            "return arguments[0].childNodes[1].textContent;", element);
                    return Double.parseDouble(priceText.trim());  // Parse the price into a Double
                })
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        Assert.assertEquals(mylist.size(), $$(".inventory_item_price").size());
        return mylist;

    }

    public static void putPricedItemInCart(Actor actor) {

        Target Button_Put_Cart = interactCartButton();
        actor.attemptsTo(
                Click.on(Button_Put_Cart));

    }

    public static void checkifIteminCart(Actor actor){

        WebElementFacade Button_Put_Cart = interactCartButton().resolveFor(actor);
        actor.attemptsTo(Ensure.that(Button_Put_Cart.getText()).isEqualToIgnoringCase("Remove"));

    }
    public static void selectItemthroughPictureLink(Actor actor){

        Target Button_Select_Item = SelectItemButton();
        actor.attemptsTo(
                Click.on(Button_Select_Item));
        Target Button_Back = Target.the("back button ").locatedBy(".inventory_details_back_button");

       Button_Back.isVisibleFor(actor);

    }


    public static void selectItemthroughTitleLink(Actor actor){

        Target Button_Select_Item = SelectItemButtonTitleLink();
        actor.attemptsTo(
                Click.on(Button_Select_Item));
        Target Button_Back = Target.the("back button ").locatedBy(".inventory_details_back_button");

        Button_Back.isVisibleFor(actor);

    }

    public static Target interactCartButton(){

       return Button_next_Price.of(price);

    }

    public static Target SelectItemButton(){
        WaitUntil.the(Button_Select_Item.of(price), WebElementStateMatchers.isVisible());
        return Button_Select_Item.of(price);

    }
    public static Target SelectItemButtonTitleLink(){
       Target Select_Item_ButtonTitle = Target.the("{0} Title link").locatedBy("(//*[text()[contains(.,'{0}')]])/parent::*/parent::*/div/a");
        WaitUntil.the(Select_Item_ButtonTitle.of(price), WebElementStateMatchers.isVisible());
        return Select_Item_ButtonTitle.of(price);

    }


}
