/** This code uses the SLF4J interface only.  It otherwise issues the same logging calls
 * as ThirdLog did. SLF4J includes a logger level more critical than Error called Fatal. */

package LoggerJam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FourthLog {
    /* Format: Year-Month-Day Hour:Minute:Second:Milliseconds LEVEL [thread] class:line number - message */

    public static void main(String[] args){

        Logger gimble = LoggerFactory.getLogger("FourthLog.class");

        if (gimble.isDebugEnabled()){
            gimble.debug("Either the belt or motor is broken."); // print DEBUG message to console
        }

        if (gimble.isInfoEnabled()){
            gimble.info("Check if the hose is clogged."); // print INFO message to console
        }

        if (gimble.isErrorEnabled()){
            gimble.error("Washer won't spin the water out."); // print ERROR message to console and file
        }

    }
}
