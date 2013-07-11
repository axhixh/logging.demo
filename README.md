# Java Demo to Demonstrate Logging Exceptions

Ashish Shrestha
11 July, 2013

# demoException()
 =================== logging of simple exception ====================
 demo of simple exception.
 java.lang.NullPointerException: simple null pointer exception
 	at np.com.axhixh.logging.demo.App.throwsException(App.java:85)
	at np.com.axhixh.logging.demo.App.demoException(App.java:42)
	at np.com.axhixh.logging.demo.App.demo(App.java:28)
	at np.com.axhixh.logging.demo.App.main(App.java:24)


# demoDoubleLogging()
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


# demoExceptionLostStack()
 =================== logging showing lost stack trace ====================
 demo of exception without cause.
 java.lang.IndexOutOfBoundsException: new exception without cause
	at np.com.axhixh.logging.demo.App.throwsWithoutCause(App.java:108)
	at np.com.axhixh.logging.demo.App.demoExceptionLostStack(App.java:69)
	at np.com.axhixh.logging.demo.App.demo(App.java:31)
	at np.com.axhixh.logging.demo.App.main(App.java:24)


# demoExceptionWithCause()
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
 

# demoReplacingStack()
 =================== logging after replacing stack trace ====================
 exception with replaced stack
 java.lang.IllegalArgumentException: new exception with old stack
	at np.com.axhixh.logging.demo.App.throwsException(App.java:85)
	at np.com.axhixh.logging.demo.App.throwsWithOldStack(App.java:113)
	at np.com.axhixh.logging.demo.App.demoReplacingStack(App.java:78)
	at np.com.axhixh.logging.demo.App.demo(App.java:32)
	at np.com.axhixh.logging.demo.App.main(App.java:24)
