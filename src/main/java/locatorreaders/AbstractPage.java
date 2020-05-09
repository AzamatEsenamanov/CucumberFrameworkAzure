package locatorreaders;


import org.openqa.selenium.By;

import java.io.IOException;

public abstract class  AbstractPage implements Page {
    protected By getLocator(String type, String element) throws IOException{
        By value;
        System.out.println("Searching for locator");
        if(type.equalsIgnoreCase("id")){
            value = By.id((element));
        }
        else if(type.equalsIgnoreCase("name")){
            value = By.name((element));
        }
        else if(type.equalsIgnoreCase("xpath")){
            value = By.xpath((element));
        }else{
            throw new IOException("Locator not found for object "+type+", "+element);
        }
        return value;
    }
}
