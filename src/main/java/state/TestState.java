package state;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class TestState {
    private Map<String, By> page;
    private WebDriver driver;
    private int timeout = 20;

    public Map<String, By> getPage() {
        return this.page;
    }

    public void setPage(Map<String, By> page) {
        this.page = page;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}