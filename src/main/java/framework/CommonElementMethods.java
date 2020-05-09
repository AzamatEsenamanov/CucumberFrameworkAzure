package framework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class CommonElementMethods extends ElementReadyStatus{
    public CommonElementMethods(WebDriver driver) {
        super(driver);
    }
    public void enterValueWhenVisible(By locator, String inputValue, int timeout) throws IOException{
        System.out.println("Starting enterValueWhenVisible method");
        System.out.println("locator on EnterValueWhenVisible Page: "+locator);
        System.out.println("inputValue on EnterValueWhenVisible Page: "+inputValue);
        try{
            //not finished, reportFunction
            System.out.println("checking if element is visible, before if block");
            if(elementVisibleAndEnabled(locator, timeout)){
                System.out.println("Element is visible");
            driver.findElement(locator).sendKeys(inputValue);
                System.out.println("Entered Keys");
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
                System.out.println("Cleared");
            }
        }catch (Exception e){
            //screen
        }
    }
    public void clickWhenVisible(By locator, int timeout) throws IOException{
        try{
            //not finished, reportFunction
            if(elementVisibleAndEnabled(locator, timeout)){
                System.out.println("Element is visible");
                driver.findElement(locator).click();
                System.out.println("Clicked");
            }
        }catch (Exception e){
            if(e.toString().contains("NullPointerException")){
                System.out.println("NullPointer at enterValueWhenVisible");
            }
            ///not finished, screenCaptureOnFailure
        }
    }
}
