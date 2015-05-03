package log4j;

import org.apache.log4j.Logger;

/** 
 * @author xiaolong
 */

public class Log4jTest {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Log4jTest.class);
		logger.debug("this is debug message...");
		logger.info("this is info message...");
		logger.error("this is error message...");  
	}
}
