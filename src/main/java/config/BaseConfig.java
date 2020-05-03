package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseConfig {
    public WebDriver driverSettings() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path +"\\src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
