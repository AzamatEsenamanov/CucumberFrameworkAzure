package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {
    private static final String GOOGLE_URL = "https://aa.com";
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToURL() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(GOOGLE_URL);
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
            this.driver.close();
            this.driver.quit();
        }catch(Exception e){
//                Logging.logError("Error during driver kill - ", e);
            System.out.println("Couldnt close window");
        }
    }
    public WebDriver driverSettings() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path +"\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}
