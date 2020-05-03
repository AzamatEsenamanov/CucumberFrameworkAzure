package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CommonElementMethods extends ElementReadyStatus{


    public void enterValueWhenVisible(WebElement locator, String inputValue, int timeout) throws IOException{
        try{
            //not finished, reportFunction
            if(elementVisibleAndEnabled(locator, timeout)){
                System.out.println("Element is visible");
                locator.sendKeys(inputValue);
                System.out.println("Sending Keys");
            }
        }catch (Exception e){
            if(e.toString().contains("NullPointerException")){
                System.out.println("NullPointer at enterValueWhenVisible");
            }
            ///not finished, screenCaptureOnFailure
        }
    }
    public void clearWhenVisible(WebElement locator)throws IOException{
        try{
            //reporting
            if(elementVisibleAndEnabled(locator, 5)){
                locator.clear();
                return;
            }
        }catch (Exception e){
            //screen
        }
    }
}
