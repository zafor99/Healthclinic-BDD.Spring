package com.zafor.heatclinic.qa.framework.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Iftekhar Ivaan on 5/15/2016.
 */
public class HomePageSteps extends BaseSteps {
    @Then("^Heatclinic home page should show$")
    public void heatclinic_home_page_should_show() throws Throwable {
        //String title = DriverFactory.getInstance().getDriver().getTitle();
        //Assert.assertEquals("Broadleaf Demo - Heat Clinic",title);
        heatclinic.homePage().verifyTitle();
    }

    @When("^User click login button$")
    public void user_click_login_button() throws Throwable {
        //driver.findElement(By.linkText("Login")).click();
        heatclinic.homePage().navigateToLoginPage();
    }
    @Then("^Welcome message shows \"([^\"]*)\"$")
    public void welcome_message_shows(String arg1) throws Throwable {
       // String text = driver.findElement(By.cssSelector(".my-account")).getText();
       // Assert.assertEquals(arg1,text);
        heatclinic.homePage().verifyUser(arg1);
    }
}
