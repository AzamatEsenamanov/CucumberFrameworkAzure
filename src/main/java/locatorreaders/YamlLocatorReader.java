package locatorreaders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.Map;

//implementation for ILocator interface
public class YamlLocatorReader implements ILocatorReader {


    // Page POJO for easy deserialization from yaml
    public static class YamlPage extends AbstractPage {
        @JsonProperty("name")
        private String name;
        private Map<String, By> pageObjects;
        public Map<String, By> getPageObjects(){
            return this.pageObjects;
        }
    }
    @Override
    public Map<String, By> read(String fileName) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Page pageData;
        try{
            pageData = mapper.readValue(new File(fileName), YamlPage.class);
        }catch (IOException e){
            throw new IOException("Error ingesting yaml: "+ e.getMessage());
        }
        return pageData.getPageObjects();
    }
    //not finished


}
