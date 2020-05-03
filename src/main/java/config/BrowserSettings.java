package config;

import io.cucumber.java8.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BrowserSettings {
    public static final String BASE_URL = "https://mail.ru";
    BaseConfig wds = new BaseConfig();
    WebDriver driver = wds.driverSettings();
    //Getters and Setters
    public WebDriver getDriver() {
        return driver;
    }
    public WebDriver BrowserSettings() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        return driver;
    }
    public WebDriver navigateTo(String locator){
        BaseConfig wds = new BaseConfig();
        WebDriver driver = wds.driverSettings();
        driver.get(locator);
        return driver;
    }
    /** Tear Down after all scenarios ran in feature file. Validates if scenario fails and logs. Else, check for UNDEFINED
     * in the scenario, which means step doesnt have unerlying java code or mispelled.
     */
    public void tearDownAfterScenario(){
//            Logging.logInfo("Scenario - " + scenario.getName()+" Failed");
//            Logging.logError("Scenario - " + scenario.getName()+" Failed");
//            getScreenShot(scenario);
//            System.out.println("Scenario failed");
//        }else if (scenario.getStatus().name().equalsIgnoreCase("Undefined")){
//            getScreenShot(scenario);
//            Logging.logError("Code snippet for Scenario '" + scenario.getName()+"' UNDEFINED Step!");
        closeDriver();
    }
        //Close and quite current driver
        private void closeDriver(){
            try{
                getDriver().close();
                getDriver().quit();
            }catch(Exception e){
//                Logging.logError("Error during driver kill - ", e);
                System.out.println("Couldnt close window");
            }
        }
}
