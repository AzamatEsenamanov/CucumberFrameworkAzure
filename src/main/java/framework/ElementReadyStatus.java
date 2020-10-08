package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ElementReadyStatus {
    //added code
    private static final Logger logger = LogManager.getLogger(ElementReadyStatus.class);
    //
    public WebDriver driver;
    public ElementReadyStatus(WebDriver driver) {
        this.driver = driver;
    }
    protected boolean elementVisibleAndEnabled(By locator, int timeout){
    try{

        if(new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled()){
//            logger.trace("We've just greeted the user!");
//            logger.debug("We've just greeted the user!");
//            logger.info("We've just greeted the user!");
//            logger.warn("We've just greeted the user!");
//            logger.error("We've just greeted the user!");
//            logger.fatal("We've just greeted the user!");
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
