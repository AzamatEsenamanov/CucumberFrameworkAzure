package locatorreaders;

import org.openqa.selenium.By;

import java.util.Map;

public interface Page {
    public Map<String, By> getPageObjects();
    public String toString();
}
