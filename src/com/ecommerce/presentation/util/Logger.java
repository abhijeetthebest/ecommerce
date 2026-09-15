package com.ecommerce.presentation.util;

import org.slf4j.LoggerFactory;

/**
 * Utility class for logging.
 */
public class Logger {
    
    /** Debug log level */
    public static final int DEBUG = 0;
    
    /** Info log level */
    public static final int INFO = 1;
    
    /** Warning log level */
    public static final int WARN = 2;
    
    /** Error log level */
    public static final int ERROR = 3;
    
    /**
     * Log a message.
     * 
     * @param level The log level
     * @param className The class name
     * @param methodName The method name
     * @param message The message
     */
    public static void log(int level, String className, String methodName, String message) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(className);
        
        String formattedMessage = methodName + ": " + message;
        
        switch (level) {
            case DEBUG:
                logger.debug(formattedMessage);
                break;
            case INFO:
                logger.info(formattedMessage);
                break;
            case WARN:
                logger.warn(formattedMessage);
                break;
            case ERROR:
                logger.error(formattedMessage);
                break;
            default:
                logger.info(formattedMessage);
                break;
        }
    }
}
