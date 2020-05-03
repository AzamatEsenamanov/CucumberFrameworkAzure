package locatorreaders;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.Map;

//to read Page Objects from xml
public class XmlLocatorReader implements ILocatorReader {


    public static class XmlPage extends AbstractPage {
        @JacksonXmlProperty(localName = "name")
        private String name;
        private Map<String, By> pageObjects;

        @Override
        public Map<String, By> getPageObjects(){
            return this.pageObjects;
        }

        @Override
        public String toString(){
            return name + pageObjects;
        }
    }
    public Map<String, By> read(String fileName) throws Exception {
        Page pageData;
        XmlMapper xmlMapper = new XmlMapper();
        try{
            pageData = xmlMapper.readValue(new File(fileName), XmlPage.class);
        }catch (IOException e){
            throw new IOException("Error ingesting XML: "+e.getMessage());
        }
        return pageData.getPageObjects();
    }
}
