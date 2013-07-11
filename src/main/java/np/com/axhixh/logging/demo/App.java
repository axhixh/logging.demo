package np.com.axhixh.logging.demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Demo to show various options when logging exceptions
 *
 */
public class App {

    public static void main(String[] args) {
        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(), "System.out"));

        Logger logger = Logger.getLogger(App.class);
        logger.info("Logging Demo");

        new App().demo(logger);
    }

    private void demo(Logger logger) {
        demoException(logger);
        demoDoubleLogging(logger);
        demoExceptionWithCause(logger);
        demoExceptionLostStack(logger);
        demoReplacingStack(logger);
    }

    private String banner(String message) {
        return "\n\n=================== " + message + " ====================";
    }
    private void demoException(Logger logger) {
        try {
            logger.warn(banner("logging of simple exception"));
            throwsException();
        } catch (Exception e) {
            logger.info("demo of simple exception.", e);
        }
    }

    private void demoDoubleLogging(Logger logger) {
        logger.warn(banner("double logging of exception"));
        try {
            throwsAfterLogging(logger);
        } catch (Exception e) {
            logger.info("double logging", e);
        }
    }

    private void demoExceptionWithCause(Logger logger) {
        try {
            logger.warn(banner("logging of exception with cause"));
            throwsWithCause();
        } catch (Exception e) {
            logger.info("demo of exception of cause.", e);
        }
    }

    private void demoExceptionLostStack(Logger logger) {
        logger.warn(banner("logging showing lost stack trace"));
        try {
            throwsWithoutCause();
        } catch (Exception e) {
            logger.info("demo of exception without cause.", e);
        }
    }

    private void demoReplacingStack(Logger logger) {
        logger.warn(banner("logging after replacing stack trace"));
        try {
            throwsWithOldStack();
        } catch (Exception e) {
            logger.info("exception with replaced stack", e);
        } 
    }

    private void throwsException() throws Exception {
        throw new NullPointerException("simple null pointer exception");
    }
    
    private void throwsAfterLogging(Logger logger) throws Exception {
        try {
            throwsException();
        } catch (Exception e) {
            logger.info("logging before throwing ", e);
            throw e;
        }
    }
    private void throwsWithCause() throws Exception {
        try {
            throwsException();
        } catch (Exception e) {
            throw new RuntimeException("exception with cause", e);
        }
    }
    
    private void throwsWithoutCause() throws Exception {
        try {
            throwsException();
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("new exception without cause");
        }
    }
    private void throwsWithOldStack() throws Exception {
        try {
            throwsException();
        } catch (Exception e) {
            Exception e2 = new IllegalArgumentException("new exception with old stack");
            e2.setStackTrace(e.getStackTrace());
            throw e2;
        }
    }
}
