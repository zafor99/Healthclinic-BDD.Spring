package com.zafor.heatclinic.qa.framework;

import com.zafor.heatclinic.qa.framework.DriverFactory;
import com.zafor.heatclinic.qa.framework.utils.SpecializedScreenRecorder;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Iftekhar Ivaan on 5/21/2016.
 */
public class BeforeAfterHooks {

    @Autowired
    private WebDriver driver;

    private String executionFeature;
    private String executingScenario;

   // private ScreenRecorder screenRecorder;


    @Before
    public void before(Scenario scenario) throws Exception {
        String scenarioId = scenario.getId();
        String featureName = scenarioId.substring(0, scenarioId.indexOf(";"));

        this.executionFeature = featureName;
        this.executingScenario = scenario.getName();

        //startRecording();
    }

    @After
    public void after(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }

        //stopRecording();
    }

   /* private void startRecording() throws Exception {
        String useDir = System.getProperty("user.home");

        File file = new File(useDir + "/CucumberVideos/"
                + this.executionFeature.replaceAll("[^a-zA-Z0-9.-]", "_"));
        String fileNameStartWith = this.executingScenario.replaceAll(
                "[^a-zA-Z0-9.-]", "_");

        //this.screenRecorder = new SpecializedScreenRecorder(file,fileNameStartWith);
        //this.screenRecorder.start();

    }*/

   // private void stopRecording() throws Exception {
        //this.screenRecorder.stop();
   // }
}
