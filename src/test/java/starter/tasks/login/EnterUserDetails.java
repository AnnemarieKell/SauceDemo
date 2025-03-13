package starter.tasks.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import starter.Pages.login.login;

public class EnterUserDetails {
    public static Performable loginCorrectCredentials(String userName, String passWord) {

        return Task.where(userName+ "logs in with " + passWord + "'",
                Enter.theValue(userName)
                                .into(login.userName),
                        Enter.theValue(passWord)
                                .into(login.passWord)
                        .thenHit(Keys.ENTER));

    }
}
