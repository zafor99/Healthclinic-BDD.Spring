package com.zafor.heatclinic.qa.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.util.StringUtils;

/**
 * Created by Iftekhar Ivaan on 5/15/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        //dryRun = true,
        //strict = true,
        //monochrome = true,
        //tags = { "@debug" },
        //tags = { "@functional","@debug" }, /*AND*/
        //tags = { "@functional,@debug" }, /*OR*/
        //tags = { "@functional,@debug","@debug" }, /*AND-OR*/
        features = "src/test/resources/features",
        glue = { "com.paxotech.heatclinic.qa.framework.steps"},
        plugin={
                "pretty:target/cucumber-test-report/cucumber-pretty.txt",
                "html:target/cucumber-test-report",
                "json:target/cucumber-test-report/cucumber-report.json",
                "junit:target/cucumber-test-report/test-report.xml",
                "json:target/test-report.json"
        }
)

//-DenvTarget=qa -Dbrowser=ie  -Dcucumber.options="--tags @debug"
public class BDDHeatclinicRunner {

        @BeforeClass
        public static void setUp(){
                String envTarget = System.getProperty("envTarget");
                if (!StringUtils.hasText(envTarget)) {
                        envTarget = "qa";
                        System.setProperty("envTarget", envTarget);
                }

                String browser = System.getProperty("browser");
                if(!StringUtils.hasText(browser)){
                        browser = "CH";
                        System.setProperty("browser", browser);
                }
        }
}
