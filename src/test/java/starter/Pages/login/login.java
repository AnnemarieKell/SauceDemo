package starter.Pages.login;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;



public class login {
    public static final Target userName = Target.the("login UserName").locatedBy("#user-name");
    public static final Target passWord =  Target.the("login Password").locatedBy("#password");
    public static final Target loginButton =  Target.the("login Button").locatedBy("#login-button");
    Target BUTTON_WITH_LABEL = Target.the("{0} button").located(By.cssSelector("//button[.='{0}']"));

//toby.attemptsTo(Click.on(BUTTON_WITH_LABEL.of('Add')));
}
