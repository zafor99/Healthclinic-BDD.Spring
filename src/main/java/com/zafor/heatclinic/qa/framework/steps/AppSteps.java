package com.zafor.heatclinic.qa.framework.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by Iftekhar Ivaan on 5/21/2016.
 */
public class AppSteps extends BaseSteps{
    @Given("^As a not validated user$")
    public void notavaliduser() throws Throwable {
        driver.manage().deleteAllCookies();
    }

    @When("^Browse to the url \"([^\"]*)\"$")
    public void browse_to_the_url(String arg1) throws Throwable {
        driver.navigate().to(arg1);
    }

    @When("^Browse to the url$")
    public void browse_to_the_url() throws Throwable {

        String url = environment.getProperty("APP_URL");
        driver.navigate().to(url);
    }
}
