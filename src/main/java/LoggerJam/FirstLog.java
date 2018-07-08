/** This is an experimental program that plays around with the selection rule and level inheritance. The program
 * prints messages based on the inheritance level assigned to the root logger. The inheritance level depends on the
 * severity of the logging request. Error messages are the most severe, while Trace messages are the least severe.
 * TRACE: least severe (top of hierarchy)
 * DEBUG: default level
 * INFO
 * WARN
 * ERROR: most severe (bottom of hierarchy)
 * This program uses the SLF4J interface to generate logs. Error logs alone are printed to a file. All logs are
 * printed to the console. */

package LoggerJam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstLog {

    /* Format: Year-Month-Day Hour:Minute:Second:Milliseconds LEVEL [thread] class:line number - message */

    /* Main Method */

    public static void main(String[] args){

        Logger timber = LoggerFactory.getLogger(FirstLog.class); // instantiate logger

        // check if root logger level is at or above DEBUG (i.e. the default root logger level)
        if (timber.isDebugEnabled()){
            timber.debug("That's more like it."); // print DEBUG message to console
        }

        // check if root logger level is at or above INFO
        if (timber.isInfoEnabled()){
            timber.info("Now it's worse."); // print INFO message to console
        }

        // check if root logger level is at or above ERROR on the hierarchy
        if (timber.isErrorEnabled()){
            timber.error("I have four words: Go suck an egg!"); // print ERROR message to console
            // Note: The error message also appears in a separate log file.
        }

        // check if root logger level is at or above WARN
        if (timber.isWarnEnabled()){
            timber.warn("Achtung! That's German for warning."); // print WARN message to console
        }

        // check if root logger level is at TRACE; skip if below TRACE on the hierarchy
        if (timber.isTraceEnabled()){
            timber.trace("Reach for the sky!  Toy Story (1995)"); // print TRACE message to console
        }
    }
}
