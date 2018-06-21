/** This is another experimental program that churns out logs using the Logback interface. The code first sets the root
 * logger level to ERROR and programmatically adjusts the root logger level. The code prints all messages to the
 * console but only error messages to a separate log file.*/

package LoggerJam;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class SecondLog {

    /* Format: Year-Month-Day Hour:Minute:Second:Milliseconds LEVEL [thread] class:line number - message */

    final static Logger plank = (Logger) LoggerFactory.getLogger(SecondLog.class); // instantiate logger

    /** beam1 sets the root logger level to ERROR, the most critical logging level. */
    public void beam1(){
        Logger switcheroo = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME); // instantiate root logger
        switcheroo.setLevel(Level.ERROR); // set root logger level to ERROR
    }

    /* Main Method */

    public static void main(String[] args){

        SecondLog sl = new SecondLog(); // instantiate constructor
        sl.beam1(); // change root logger level to ERROR

        plank.error("He's dead Jim. - Dr McCoy."); // print ERROR message to console and log file

        // This loop sets the root logger level to WARN if the root level is below WARN
        if (!plank.isWarnEnabled()){
            plank.setLevel(Level.WARN); // set root logger level to WARN
            plank.warn("To do is to be! - Jean Paul Sartre"); // print WARN message to console
        }

        // This loop runs if the inheritance level is below INFO.
        if (!plank.isInfoEnabled()){
            plank.setLevel(Level.INFO); // set root level to INFO
            plank.info("To be is to do! - Socrates"); // print INFO message to console
        }

        // DEBUG is the default logger level.
        if (!plank.isDebugEnabled()){
            plank.setLevel(Level.DEBUG); // set root level to DEBUG
            plank.debug("Do or do not. There is no try. - Yoda"); // print DEBUG message to console
        }

        /* This loop prints a TRACE message to the console if the root logger level is set at TRACE, the least severe
        logger level possible. Otherwise, the code skips this loop. Unlike the other loops, this loop does not
        adjust the root logger level. */

        if (plank.isTraceEnabled()){
            plank.trace("Yabba Dabba Doo! - Fred Flintstone"); // print TRACE message to console
        }
    }
}