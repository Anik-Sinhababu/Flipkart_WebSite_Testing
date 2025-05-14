package utils;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class LoggerHandler {
	public Logger log = LogManager.getLogger(LoggerHandler.class);
 
	public void logInfo(String message) {
		log.info(message);
	}
 
	public void logError(String message) {
		log.error(message);
	}
 
	public void logWarn(String message) {
		log.warn(message);
	}
 
	public void logDebug(String message) {
		log.debug(message);
	}
 
	public void logFatal(String message) {
		log.fatal(message);
	}
 
	public void logTrace(String message) {
		log.trace(message);
	}
}