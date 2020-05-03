package locatorreaders;

import org.openqa.selenium.By;

import java.util.Map;

//Interface to read in locator info
public interface ILocatorReader {
    //returns Map between a given alias and its corresponding code By
Map<String, By> read(String fileName) throws Exception;
}
