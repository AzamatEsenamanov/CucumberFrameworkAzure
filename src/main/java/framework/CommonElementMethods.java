package framework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class CommonElementMethods extends ElementReadyStatus{
    public CommonElementMethods(WebDriver driver) {
        super(driver);
    }
    public void enterValueWhenVisible(By locator, String inputValue, int timeout) throws IOException{
        try{
            //not finished, reportFunction
            if(elementVisibleAndEnabled(locator, timeout)){
            driver.findElement(locator).sendKeys(inputValue);
            }
        }catch (Exception e){
            if(e.toString().contains("NullPointerException")){
                System.out.println("NullPointer at enterValueWhenVisible");
            }
            ///not finished, screenCaptureOnFailure
        }
    }
    public void clearWhenVisible(By locator)throws IOException{
        try{
            //reporting
            if(elementVisibleAndEnabled(locator, 5)){
               driver.findElement(locator).clear();
            }
        }catch (Exception e){
            //screen
        }
    }
    public void clickWhenVisible(By locator, int timeout) throws IOException{
        try{
            //not finished, reportFunction
            if(elementVisibleAndEnabled(locator, timeout)){
                driver.findElement(locator).click();
            }
        }catch (Exception e){
            if(e.toString().contains("NullPointerException")){
                System.out.println("NullPointer at enterValueWhenVisible");
            }
            ///not finished, screenCaptureOnFailure
        }
    }
}
