package commandline;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestLogger {

    static private FileHandler testlogHTML;
    static private Formatter formatterHTML;
    
	public static void initializeLogger() throws IOException{
		Logger testlog = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
		testlog.setLevel(Level.FINE);
		testlogHTML = new FileHandler("testlog.html");
		
		formatterHTML = new SpecialFormatter();
		testlogHTML.setFormatter(formatterHTML);
        testlog.addHandler(testlogHTML);
	}

	public static void closeLogger() {
		testlogHTML.close();
	}
}