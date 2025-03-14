package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theSauceDemoLogin() {
        return Task.where("{0} opens the Sauce Demo Login  page",
                Open.browserOn().the(SauceDemoLoginPage.class));
    }
}
