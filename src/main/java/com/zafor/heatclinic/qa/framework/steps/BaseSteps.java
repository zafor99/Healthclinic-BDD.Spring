package com.zafor.heatclinic.qa.framework.steps;

import com.zafor.heatclinic.qa.framework.pages.Application;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * Created by Iftekhar Ivaan on 5/15/2016.
 */
public class BaseSteps {
    @Autowired
    protected Environment environment;
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected Application heatclinic;

}
