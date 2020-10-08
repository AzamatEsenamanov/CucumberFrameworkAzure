package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker;

import java.util.Map;
public class GetBase {

    private WebDriver driver;
    private Map<String, By> page;
    private int timeout = 20;

    //Getters and Setters
    public int getTimeout() {
        return this.timeout;
//        WebElement title = driver.findElement(By.xpath("//h1[text()='Todos']"));
//        String t = title.getText();
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

//    Object object = val;
//    String newToDo = object.toString();
//    driver.get(Url);
//    WebElement input = driver.findElement(By.xpath(""));
//    input.
}
