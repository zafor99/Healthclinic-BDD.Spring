package com.zafor.heatclinic.qa.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Iftekhar Ivaan on 5/15/2016.
 */
public class DriverFactory {

    public static final String USERNAME = "iftekharivaan1";
    public static final String AUTOMATE_KEY = "WsjTqspKpUUjt4sLbSza";
    public static final String REMOTE_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    private DriverFactory()
    {
        //Do-nothing..Do not allow to initialize this class from outside
    }
    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance()
    {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        @Override
        protected WebDriver initialValue()
        {



            URL SELENIUM_HUB = null;

            try {
                SELENIUM_HUB = new URL("http://10.10.30.140:4444/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            String driverName =   "";//ResourceFactory.getInstance().getProperty("DRIVER").toString();
            if(driverName.toUpperCase().contentEquals("CH")){
                String chromeBinayPath;
                chromeBinayPath =  System.getProperty("user.dir") + "/src/main/resources/driver/32/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromeBinayPath);
                return new ChromeDriver();
            }
            else if(driverName.toUpperCase().contentEquals("IE")){
                String ieBinayPath;
                ieBinayPath = System.getProperty("user.dir") + "/src/main/resources/driver/32/IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", ieBinayPath );
                return new InternetExplorerDriver();
            }
            else if(driverName.toUpperCase().contentEquals("FF")){
                return new FirefoxDriver();
            }
            else if(driverName.toUpperCase().contentEquals("PHANTOMJS")){
                String phantomBinayPath;
                phantomBinayPath = System.getProperty("user.dir") + "/src/main/resources/driver/32/phantomjs.exe";
                System.setProperty("phantomjs.binary.path", phantomBinayPath);
                return new PhantomJSDriver();
            }
            else if(driverName.toUpperCase().contentEquals("R-FF")){
                WebDriver driver = null;
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                // driver = new RemoteWebDriver(new URL("http://10.10.30.35:4444/wd/hub"),capabilities);
                driver = new RemoteWebDriver(SELENIUM_HUB,capabilities);
                return driver;
            }
            else if(driverName.toUpperCase().contentEquals("R-CH")){
                WebDriver driver = null;
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(SELENIUM_HUB,capabilities);
                return driver;
            }
            else if(driverName.toUpperCase().contentEquals("BS-IE")){
                DesiredCapabilities caps = new DesiredCapabilities();

                caps.setCapability("browser", "IE");
                caps.setCapability("browser_version", "11.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1280x1024");

               /*
                caps.setCapability("browser", "Safari");
                caps.setCapability("browser_version", "5.1");
                caps.setCapability("os", "OS X");
                caps.setCapability("os_version", "Snow Leopard");
                caps.setCapability("resolution", "1280x1024");
                */
                /*
                caps.setCapability("browserName", "iPhone");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPhone 6S Plus");
                */
                caps.setCapability("browserstack.debug", "true");

                WebDriver driver = null;
                try {
                    driver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return driver;
            }
            else {
                return new FirefoxDriver(); // can be replaced with other browser drivers
            }
        }
    };

    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }

    public void removeDriver() // Quits the driver and closes the browser
    {
        driver.get().quit();
        driver.remove();
    }
}
