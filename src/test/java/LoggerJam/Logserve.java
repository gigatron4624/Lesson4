/** This program uses TestNG Assertion methods to supplement the LoggerJam codes. LogServe, a portmanteau
 * of log and observe, runs tests to confirm whether or not an error log exists and if the error log contains
 * certain lines. */

package LoggerJam;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    /** firstline reads the first line of a file and stores it as a string
     * @param fn is the name of the file (fn = filename)
     * @return the first line of the file
     * @throws IOException if the file is restricted (i.e. can't open or read file contents) */
    private String firstline(String fn) throws IOException{
        // pull file contents
        StringBuilder pull = new StringBuilder(); // initialize blank string builder

        // Attempting to read the target file might throw a File Not Found Exception.
        try{
            BufferedReader rfl = new BufferedReader(new FileReader(fn)); // rf: read file
            pull.append(rfl.readLine());
        }

        // The file that is being accessed is either absent or a directory.
        catch (FileNotFoundException ouch){
            // The read function cannot read a directory or empty space.
            return "File not found! Searching oblivion is forbidden sucker! " + ouch.getMessage();
        }
        return pull.toString(); // this is the first line
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
    void errorexclusive() throws IOException{
        String efll = "ERROR"; // efll = effective logger level
        String fl = firstline("CriticalRecordsOnly.log"); // fl = firstline
        String tll = fl.substring(24,29); // tll = true logger level
        Assert.assertEquals(tll, efll, boo());
    }
}
