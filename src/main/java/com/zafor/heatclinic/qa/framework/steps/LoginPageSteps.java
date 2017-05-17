package com.zafor.heatclinic.qa.framework.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Iftekhar Ivaan on 5/15/2016.
 */
public class LoginPageSteps extends BaseSteps {


    @When("^Enter \"([^\"]*)\" as emaill address$")
    public void enter_as_emaill_address(String arg1) throws Throwable {
        //driver.findElement(By.name("j_username")).sendKeys(arg1);
        heatclinic.loginPage().enterEmailAddress(arg1);
    }

    @When("^Enter \"([^\"]*)\" as password$")
    public void enter_as_password(String arg1) throws Throwable {
       // driver.findElement(By.name("j_password")).sendKeys(arg1);
        heatclinic.loginPage().enterPassword(arg1);
    }

    @When("^Click login$")
    public void click_login() throws Throwable {
        //driver.findElement(By.cssSelector(".login_button.big.red")).click();
        heatclinic.loginPage().clickLogin();
    }

    @Then("^Invalid email or password message display$")
    public void invalid_email_or_password_message_display() throws Throwable {
        heatclinic.loginPage().verifyLoginErrorMsg();
       //String msg =  driver.findElement(By.cssSelector(".error>p>span")).getText();
       // Assert.assertEquals("The e-mail address and/or password entered do not match our records. Please try again",msg);
    }

    @Then("^Invalid email or password message not display$")
    public void invalid_email_or_password_message_not_display() throws Throwable {

       /* driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        try {
            driver.findElement(By.cssSelector(".error>p>span"));
            Assert.assertTrue(true);
        }
        catch (NoSuchElementException ex){
            Assert.assertFalse(false);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/

        heatclinic.loginPage().verifyLoginErrorMsgNotDisplay();
    }


}
