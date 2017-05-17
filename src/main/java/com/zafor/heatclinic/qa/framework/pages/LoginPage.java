package com.zafor.heatclinic.qa.framework.pages;

import com.zafor.heatclinic.qa.framework.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Iftekhar Ivaan on 5/28/2016.
 */
@PageObject
public class LoginPage {
    @Autowired
    private WebDriver driver;
    private int TimeoutValue = 30;

    @FindBy(how = How.NAME,using = "j_username" )
    private WebElement emailTextbox;

    @FindBy(name = "j_password")
    private WebElement passwordTextbox;

    @FindBy(css = ".login_button.big.red")
    private WebElement loginButton;

    @FindBy(css = ".error>p>span")
    private WebElement errorLable;

    //@FindBys(how = How.TAG_NAME, using = "a")
    private List<WebElement> links;

    public LoginPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
    }

    public void enterEmailAddress(String email){
        emailTextbox.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordTextbox.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public void login(String email, String password){
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        loginButton.click();
    }
    public void verifyLoginErrorMsg(){
        String MSG = "The e-mail address and/or password entered do not match our records. Please try again";

        String text = errorLable.getText();
        Assert.assertEquals(text,MSG);
    }

    public void verifyLoginErrorMsgNotDisplay(){

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

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

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
}
