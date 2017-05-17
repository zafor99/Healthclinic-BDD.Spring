package com.zafor.heatclinic.qa.framework.pages;

import com.zafor.heatclinic.qa.framework.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by Iftekhar Ivaan on 5/28/2016.
 */

@PageObject
public class HomePage {

    @Autowired
    private WebDriver driver = null;
    @Autowired
    private Environment environment;

    private int TimeoutValue = 30;

    @FindBy(how = How.LINK_TEXT,using = "Login" )
    private WebElement loginLink;

    @FindBy(css = ".my-account")
    private WebElement userName;


    public HomePage(){
       // this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
    }

    public void navigateTo(){
        driver.navigate().to(environment.getProperty("APP_URL"));
    }

    public void navigateToLoginPage(){
        loginLink.click();
    }

    public void verifyUser(String user){
        String text = userName.getText();
        Assert.assertEquals(text,user);
    }

    public void verifyTitle(String expectedTitle){
        String title = driver.getTitle();
        Assert.assertEquals("Broadleaf Demo - Heat Clinic",title);
    }
    public void verifyTitle(){
        String title = driver.getTitle();
        Assert.assertEquals("Broadleaf Demo - Heat Clinic",title);
    }
}
