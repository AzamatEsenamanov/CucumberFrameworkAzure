package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementReadyStatus {
    public WebDriver driver;
    public ElementReadyStatus(WebDriver driver) {
        this.driver = driver;
    }
    protected boolean elementVisibleAndEnabled(By locator, int timeout){
    try{
        System.out.println("trying to locate element: "+locator+" if visible");

        if(new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled()){
            return true;
        }else{
//            not finished, screenCaptureOnFailure
            System.out.println("Cannot find locator");
        }
    }catch (Exception e){
        if(e.toString().contains("NullPointerException")){
            System.out.println("NullPointer at elementVisibleAndEnabled");
        }
    }
    return false;
}

}
