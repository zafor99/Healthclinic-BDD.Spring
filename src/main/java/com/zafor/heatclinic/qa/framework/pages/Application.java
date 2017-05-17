package com.zafor.heatclinic.qa.framework.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by Iftekhar Ivaan on 5/28/2016.
 */

@Service
public class Application {
    @Autowired
    private WebDriver driver;
    @Autowired
    private Environment environment;
    @Autowired
    private HomePage homePage;
    @Autowired
    private LoginPage loginPage;


    public void navigateToApplication(){
        driver.navigate().to(environment.getProperty("APP_URL").toString());
    }

    public HomePage homePage(){
        //PageFactory.initElements(driver, homePage);
        return homePage;
    }
    public LoginPage loginPage(){
        //PageFactory.initElements(driver, loginPage);
        return loginPage;
    }

}
