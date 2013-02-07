// Andrew Pratt
// (970) 846-1352
// andrewppratt@yahoo.com
// rowCount.java
// Accepts one argument: file name
// Will reject any argument that is not a .txt or .csv file
// Developed on Oracle JDevloper 11g Release 2
// January 21, 2013
//

package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class rowCount {

  public static void main(String[] args) throws Exception {
 
// Error check: if the file does not have .txt or .csv file extention, terminate with message
    // get the last 4 characters of the main argument
    String lastFourChars = args[0].substring(args[0].length() - 4);
    if (!(lastFourChars.equals(".txt")) && !(lastFourChars.equals(".csv"))){
        System.out.println("Incompatible file format. Please use a .txt or .csv file.");
        System.exit(0);
    }
    
    // create an object representing the file
    File f = new File(args[0]);
      
    // wrap it with classes for convenient access
    BufferedReader r = new BufferedReader(new FileReader(f));

    

//  If file is .txt, iterate through the file and count lines. 
// readline() Reads a line of text. A line is considered to be terminated by any one of a line feed ('\n'), 
// a carriage return ('\r'), or a carriage return followed immediately by a linefeed.

    
    if (lastFourChars.equals(".txt")) {
        String x; int count = 0;
        
        while ((x = r.readLine()) != null) {
             ++count;
            //System.out.println(x);
           }
        System.out.println("The number of rows in " + args[0] + " is " + (count));
    }
//
//  Counting the rows of a csv file is more involved.  I have attempted to addrress the issue stated in the specs
//  in that if a carriage return or a new line occur between quotes, they are to be ignored and not considered a new
//  row as they are part of a record.
//          
    boolean openQuotes = false;
    if (lastFourChars.equals(".csv")) {
        int x; 
        int count = 0;
        char ch;
        while ((x = r.read()) != -1) {
            ch = (char) x;
            // if openQuotes is true, CR(13) and NL(10) should not be counted as they 'presumably' exist inside a record
            if (ch == '"') { openQuotes = !openQuotes; }
            // 13 is the decimal value of CR and 10 is the value of NL
            if ((x == 13)&& !openQuotes) { 
                x = r.read();
                if (x == -1){ break; } // Get next char and check for end of stream
                else 
                    ch = (char) x;
                    if (ch == '"') { openQuotes = !openQuotes; }
                    if (x == 10){ ++count;}
                }
        }
        // Print row count to the screen
        System.out.println("The number of rows in " + args[0] + " is " + (count));
      }
    // close resources
    r.close(); 
  }

}
