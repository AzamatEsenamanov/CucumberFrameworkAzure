package locatorreaders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//implementation for ILocator interface
public class YamlLocatorReader implements ILocatorReader {
    // Page POJO for easy deserialization from yaml
    public static class YamlPage extends AbstractPage {
        @JsonProperty("name")
        private String name;
        private Map<String, By> pageObjects;
        public Map<String, By> getPageObjects() {
            return this.pageObjects;
        }

        @JsonProperty("page-objects")
        public void unpackObjects(Map<String, Object> objects) throws IOException {
            pageObjects =new HashMap<>();
            for(Map.Entry<String, Object> pageObject: objects.entrySet()){
                String key = pageObject.getKey();
                By value;
                //returns value of xpath/id/name "xpath://*[contains.....]"
                String valOfAlias = (String)pageObject.getValue();
                int index = valOfAlias.indexOf(":");
                if(index > -1){
                    String typeOfElement = valOfAlias.substring(0, index).trim();
                    String elementValue = valOfAlias.substring(index+1).trim();
                    value = super.getLocator(typeOfElement, elementValue);
                }else{
                    throw new IOException("Error: no colon found separating identifier from type: "+valOfAlias);
                }
                pageObjects.put(key, value);
            }
        }
        public String toString(){
            return name+ pageObjects;
        }
    }
    @Override
    public Map<String, By> read(String fileName) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Page pageData;
        try {
            pageData = mapper.readValue(new File(fileName), YamlPage.class);
        } catch (IOException e) {
            throw new IOException("Error ingesting yaml: " + e.getMessage());
        }
        return pageData.getPageObjects();
    }
    //not finished


}
