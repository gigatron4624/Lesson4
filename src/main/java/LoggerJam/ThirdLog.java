/** The purpose of this code is to print Logback records to the console in the following order: debug, info, and error.
 * The error message is also exported to a log file. */

package LoggerJam;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class ThirdLog {

    /* Format: Year-Month-Day Hour:Minute:Second:Milliseconds LEVEL [thread] class:line number - message */

    static final Logger xylem = (Logger) LoggerFactory.getLogger(ThirdLog.class);

    /** fwoosh adjusts the root logger level
     * @param L is the new logger level */
    public void fwoosh(Level L){
        Logger swap = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME); // instantiate logger
        swap.setLevel(L); // change the logger level
    }

    /* Main Method */

    public static void main(String[] args){

        ThirdLog phloem = new ThirdLog(); // instantiate constructor

        phloem.fwoosh(Level.ERROR); // set root logger level to ERROR

        // check if root logger level is below INFO
        if (!xylem.isInfoEnabled()){
            phloem.fwoosh(Level.INFO); // set root logger level to INFO

        }
        // The default root logger level should be DEBUG.
        if (!xylem.isDebugEnabled()){
            phloem.fwoosh(Level.DEBUG); // set level to DEBUG
        }

        xylem.debug("Snap!"); // print DEBUG message to console
        xylem.info("Crackle!"); // print INFO message to console
        xylem.error("Pop!"); // print ERROR message to console and log file

    }
}
