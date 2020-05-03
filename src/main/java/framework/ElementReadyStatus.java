package framework;

import config.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementReadyStatus {
BrowserSettings browserSettings = new BrowserSettings();
WebDriver driver = browserSettings.getDriver();
protected boolean elementVisibleAndEnabled(WebElement locator, int timeout){
    try{
        if(new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(locator)).isEnabled()){
            return true;
        }else{
//            not finished, screenCaptureOnFailure
        }
    }catch (Exception e){
        if(e.toString().contains("NullPointerException")){
            System.out.println("NullPointer at elementVisibleAndEnabled");
        }
    }
    return false;
}

}
