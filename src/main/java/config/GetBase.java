package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;
public class GetBase {

    private WebDriver driver;
    private Map<String, By> page;
    private int timeout = 20;

    //Getters and Setters
    public int getTimeout() {
        return this.timeout;
    }
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    public Map<String, By> getPage() {
        return this.page;
    }
    public void setPage(Map<String, By> page) {
        this.page = page;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
