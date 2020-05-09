package utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

//for common File operations
public class FileFunctions {
    private static final Logger LOGGER = Logger.getLogger(FileFunctions.class.getName());
    private FileFunctions(){
        throw new IllegalStateException("Utility class");
    }
    //list file in dir recursively
    public static List<String> listf(String directoryName){
        try{
            File dir = new File(directoryName);
            List<String> resultList = new ArrayList<>();

            File[] fList = dir.listFiles();
            for(File file: fList){
                if (file.isFile()) {
                    resultList.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    //search recursively if dir
                    resultList.addAll(listf(file.getAbsolutePath()));
                }
            }
            return resultList;
        }catch (NullPointerException e){
            LOGGER.info(e.getMessage());
            return Collections.emptyList();
        }
    }
}
