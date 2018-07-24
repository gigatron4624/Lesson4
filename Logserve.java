/** This program uses TestNG Assertion methods to supplement the LoggerJam codes. LogServe, a portmanteau
 * of log and observe, runs tests to confirm whether or not an error log exists and if the error log contains
 * certain lines. */

package LoggerJam;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class Logserve {

    /** This method returns an error message in the event I messed up.
     * @return a message expressing disapproval*/
    private String boo(){
        return "That's it. I'm going home. I'm tired. "; // cue the crowd booing, hence the method name
    }

    /** eureka searches for a file to confirm its existence.
     * @param fn is the name of the file (fn = filename)
     * @return true if the file exists and false if it doesn't. */
    private boolean eureka(String fn){
        File lwif = new File(fn); // lwif = look what I found!
        return lwif.exists(); // Eureka! I found the file!
    }

    /* Assertion Tests */
    /* The first test, logfinder, uses AssertTrue to confirm that the error log exists.
     * The second test, hollow, checks if the log is empty using AssertFalse. The log shouldn't be empty.
     * The final test, errorexclusive, uses AssertEquals to examine the text inside the log.
     * Note: LogServe must be run after FirstLog is run. */

    @Test(alwaysRun = true)
    void logfinder() throws IOException{
        boolean woot = eureka("CriticalRecordsOnly.log");
        Assert.assertTrue(woot,boo());
    }

    @Test(dependsOnMethods = {"logfinder"})
    void hollow(){
        File lf = new File("CriticalRecordsOnly.log");
        Assert.assertFalse(lf.length() == 0, boo());
    }

    @Test(dependsOnMethods = {"hollow"})
    void errorexclusive(){
        String efll = "ERROR"; // efll = effective logger level
        File lf = new File("CriticalRecordsOnly.log");
        String tll = "ERROR"; // tll = true logger level
        Assert.assertEquals(tll, efll, boo());
    }
}