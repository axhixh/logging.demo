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

    private Logger logger;
    
    App(Logger logger) {
        this.logger = logger;
        logger.info("Demo to Show Exception Logging");
    }
    
    public static void main(String[] args) {
        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(), "System.out"));

        new App(Logger.getLogger(App.class)).demo();
    }

    private void demo() {
        demoException();
        demoDoubleLogging();
        demoExceptionLostStack();
        demoExceptionWithCause();
        demoReplacingStack();
    }

    private void banner(String message) {
        logger.info("\n\n=================== " + message + " ====================");
    }
    
    private void demoException() {
        banner("logging of simple exception");
        try {
            throwsException();
        } catch (Exception e) {
            logger.info("demo of simple exception.", e);
        }
    }

    private void demoDoubleLogging() {
        banner("double logging of exception");
        try {
            throwsAfterLogging();
        } catch (Exception e) {
            logger.info("double logging", e);
        }
    }

    private void demoExceptionWithCause() {
        banner("logging of exception with cause");
        try {
            throwsWithCause();
        } catch (Exception e) {
            logger.info("demo of exception of cause.", e);
        }
    }

    private void demoExceptionLostStack() {
        banner("logging showing lost stack trace");
        try {
            throwsWithoutCause();
        } catch (Exception e) {
            logger.info("demo of exception without cause.", e);
        }
    }

    private void demoReplacingStack() {
        banner("logging after replacing stack trace");
        try {
            throwsWithOldStack();
        } catch (Exception e) {
            logger.info("exception with replaced stack", e);
        } 
    }

    private void throwsException() throws Exception {
        throw new NullPointerException("simple null pointer exception");
    }
    
    private void throwsAfterLogging() throws Exception {
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
