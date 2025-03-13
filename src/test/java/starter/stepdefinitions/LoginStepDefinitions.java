package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import starter.tasks.login.EnterUserDetails;
import starter.navigation.NavigateTo;

public class LoginStepDefinitions {
    @Given("{actor} logged into the website")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSauceDemoLogin());
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        actor.wasAbleTo(EnterUserDetails.loginCorrectCredentials(EnvironmentSpecificConfiguration.from(variables).getProperty("userName"), EnvironmentSpecificConfiguration.from(variables).getProperty("password")));
    }
}
