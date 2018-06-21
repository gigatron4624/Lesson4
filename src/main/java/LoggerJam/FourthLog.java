/** This code uses the SLF4J interface instead of the Logback interface. It otherwise issues the same logging calls
 * as ThirdLog did. SLF4J includes a logger level more critical than Error called Fatal. */

package LoggerJam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FourthLog {
    /* Format: Year-Month-Day Hour:Minute:Second:Milliseconds LEVEL [thread] class:line number - message */

    static final Logger gimble = LoggerFactory.getLogger("FourthLog.class");

    public static void main(String[] args){

        gimble.debug("Gunter glieben glauten globen!"); // print DEBUG message to console
        gimble.info("Gunter glieben glauten globen!"); // print INFO message to console
        gimble.error("Gunter glieben glauten globen!"); // print ERROR message to console and file
    }
}