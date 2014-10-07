# Exceptions and Logging Exceptions

Ashish Shrestha

11 July, 2013

## demoException()

    =================== logging of simple exception ====================
    demo of simple exception.
    java.lang.NullPointerException: simple null pointer exception
        at np.com.axhixh.logging.demo.App.throwsException(App.java:85)
        at np.com.axhixh.logging.demo.App.demoException(App.java:42)
        at np.com.axhixh.logging.demo.App.demo(App.java:28)
        at np.com.axhixh.logging.demo.App.main(App.java:24)

The first demo is a shows logging of an exception. Logging an exception in log4j 
logs the message, exception type and the stack trace.


## demoDoubleLogging()
    =================== double logging of exception ====================
    logging before throwing 
    java.lang.NullPointerException: simple null pointer exception
        at np.com.axhixh.logging.demo.App.throwsException(App.java:85)
        at np.com.axhixh.logging.demo.App.throwsAfterLogging(App.java:90)
        at np.com.axhixh.logging.demo.App.demoDoubleLogging(App.java:51)
        at np.com.axhixh.logging.demo.App.demo(App.java:29)
        at np.com.axhixh.logging.demo.App.main(App.java:24)
    double logging
    java.lang.NullPointerException: simple null pointer exception
        at np.com.axhixh.logging.demo.App.throwsException(App.java:85)
        at np.com.axhixh.logging.demo.App.throwsAfterLogging(App.java:90)
        at np.com.axhixh.logging.demo.App.demoDoubleLogging(App.java:51)
        at np.com.axhixh.logging.demo.App.demo(App.java:29)
        at np.com.axhixh.logging.demo.App.main(App.java:24)

The above example shows the same exception logged twice since it is logged before 
rethrowing it. It is recommended that you don't log the exception that you are 
going to throw again as it doesn't add much value in the log.

## demoExceptionLostStack()
    =================== logging showing lost stack trace ====================
    demo of exception without cause.
    java.lang.IndexOutOfBoundsException: new exception without cause
        at np.com.axhixh.logging.demo.App.throwsWithoutCause(App.java:108)
        at np.com.axhixh.logging.demo.App.demoExceptionLostStack(App.java:69)
        at np.com.axhixh.logging.demo.App.demo(App.java:31)
        at np.com.axhixh.logging.demo.App.main(App.java:24)

Here the old exception is caught and a new exception is thrown instead. We loose
the information of the original exception. We loose the location where the original 
exception is thrown. One way to retain this information is to log the old exception 
before throwing the new exception. This will show two instances of exceptions logged.

Alternative methods are shown in examples below.

## demoExceptionWithCause()
    =================== logging of exception with cause ====================
    demo of exception of cause.
    java.lang.RuntimeException: exception with cause
        at np.com.axhixh.logging.demo.App.throwsWithCause(App.java:100)
        at np.com.axhixh.logging.demo.App.demoExceptionWithCause(App.java:60)
        at np.com.axhixh.logging.demo.App.demo(App.java:30)
        at np.com.axhixh.logging.demo.App.main(App.java:24)
    Caused by: java.lang.NullPointerException: simple null pointer exception
        at np.com.axhixh.logging.demo.App.throwsException(App.java:85)
        at np.com.axhixh.logging.demo.App.throwsWithCause(App.java:98)
        ... 3 more
 
Whenever you need to throw a new exception as a result of the old exception it is 
a good idea to use the old exception as the cause of the new exception. This saves 
the information about the old exception.

## demoReplacingStack()
    =================== logging after replacing stack trace ====================
    exception with replaced stack
    java.lang.IllegalArgumentException: new exception with old stack
        at np.com.axhixh.logging.demo.App.throwsException(App.java:85)
        at np.com.axhixh.logging.demo.App.throwsWithOldStack(App.java:113)
        at np.com.axhixh.logging.demo.App.demoReplacingStack(App.java:78)
        at np.com.axhixh.logging.demo.App.demo(App.java:32)
        at np.com.axhixh.logging.demo.App.main(App.java:24)

An alternative options is to replace the stack of the new exception with the 
stack of the old exception. This has the advantage of not making the exception 
log long and still keeping the original location of the exception. The 
disadvantage is that the original exception is lost. In the example, the original 
exception was a NullPointerException. We lost that information, but the stack 
hasn't increased and the original exception location of line 85 is retained.

## demoTryResourcesSuppression()
