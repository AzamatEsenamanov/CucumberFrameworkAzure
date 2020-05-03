package state;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class PageObjectMap extends HashMap<String, By> {
    //Auto seialization ID
    private static final long serialVersion = -4407519697856248682L;
    private transient WebDriver driver;
    private int timeout;
    //creates an instance of code PageObjectMap

    public PageObjectMap(Map<String, By> map, WebDriver driver, int timeout) {
        super(map);
        this.driver = driver;
        this.timeout = timeout;
    }
    @Override
    public By get(Object key){
        By identifier = null;
        if(super.containsKey(key)){
            identifier = super.get(key);
        }else{
            try{
                new WebDriverWait(this.driver, this.timeout).until(ExpectedConditions.presenceOfElementLocated(By.id((String) key)));
                identifier = By.id((String) key);
            }catch (TimeoutException e){
                identifier = null;
            }
        }
        if (identifier == null) {
//            Assert.fail("Null Object in Map or ID");
        }
        return identifier;
    }
    protected WebDriver getDriver(){
        return this.driver;
    }
    @Override
    public boolean equals(Object object){
        if (object != null && object.getClass() == this.getClass()) {
            return super.equals(object) && ((PageObjectMap) object).getDriver().equals(this.getDriver());
        }else{
            return false;
        }
    }
    @Override
    public int hashCode(){
        return super.hashCode()+this.driver.hashCode();
    }
}
