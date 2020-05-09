package utilities;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Log4j methods, static Class methods can be used in all classes and test classes.
public class Logging {
    protected static Logger log = LogManager.getLogger();
    protected static Logger debug = LogManager.getLogger("DebugLogger");
    private static String logFileDirectory;

    // not finished

    public static void logWarning(String message){
        debug.log(Level.WARN, message);
    }
    //Log errors
    public static void logError(String error, Exception e){
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        logStackTraceMessage(Level.ERROR, error, stackTraceElements);
    }
    public static void logError(String error){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        logStackTraceMessage(Level.ERROR, error, stackTraceElements);
    }
    public static void logStackTraceMessage(Level level, String message, StackTraceElement[] stackTraceElements){
        debug.log(level, message + "\n---------->");
        //loop each element in the stack
        for(StackTraceElement ele: stackTraceElements){
            debug.log(level, ele.getClassName()+" "
                    + ele.getMethodName()+" "
                    + ele.getLineNumber()   );
        }
    }


    //Log info for Log file
    public static void logInfo(String message){
        debug.log(Level.DEBUG, message);
    }

    public static void setLogFileDirectory(String logFileDirectory){
        Logging.logFileDirectory = logFileDirectory;
    }
}
