package quien;

/**
 * <p>Title: A Program that Displays Itself Without Any File Access</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: University of Texas at Dallas</p>
 * @author Timothy P. Farage
 * @version 1.0
 */

/**
 * This is a cool program that when run will display itself.
 * (Comments are excluded to make it easier to read).
 * The secret is to create an array of Strings that contain the lines
 * of the program, except for the Strings in the array itself.
 * So you have a first loop to display the lines of code before the
 * array of Strings.
 * Then you have a loop to display the array Strings, and then you
 * have a loop to display the array Strings that represent the remaining
 * lines of code.
 *
 * Note that the ASCII value for a space character is 32 and
 * the ASCII value for a double quote mark is 34.
 * The reason for creating 'quote' and 'sixSpaces' below is so that when
 * displaying them, is to avoid having to use the escape char \, when
 * trying to display quotes.
 */
public class ProgramThatDisplaysItself {

  public static void main(String[] args) {
    char space = (char)32;
    char quote = (char)34;
    String emptyStr = new String();
    String spaceStr = String.valueOf(space);
    String sixSpaces =
      emptyStr.concat(spaceStr).concat(spaceStr).concat(spaceStr)
              .concat(spaceStr).concat(spaceStr).concat(spaceStr);

    String linesOfCode[] = {
      "package quien;",
      "",
      "public class ProgramThatDisplaysItself {",
      "",
      "  public static void main(String[] args) {",
      "    char space = (char)32;",
      "    char quote = (char)34;",
      "    String emptyStr = new String();",
      "    String spaceStr = String.valueOf(space);",
      "    String sixSpaces = ",
      "      emptyStr.concat(spaceStr).concat(spaceStr).concat(spaceStr)",
      "              .concat(spaceStr).concat(spaceStr).concat(spaceStr);",
      "",
      "    String linesOfCode[] = {",
// Note: here's where the String array itself is skipped
      "    };",
      "",
      "    for ( int i = 0; i < 14; i++ ) {",
      "      System.out.println( linesOfCode[i] );",
      "    } // end for i",
      "",
      "    for ( int j = 0; j < linesOfCode.length; j++ ) {",
      "      System.out.println( sixSpaces + quote + linesOfCode[j] + quote + ',' );",
      "    } // end for j",
      "",
      "    for ( int k = 14; k < linesOfCode.length; k++ ) {",
      "      System.out.println( linesOfCode[k] );",
      "    } // end for k",
      "",
      "  } // end main()",
      "",
      "} // end class ProgramThatDisplaysItself",
    }; // end linesOfCode[]
    //display the lines until the String array elements
    for ( int i = 0; i < 14; i++ ) {
      System.out.println( linesOfCode[i] );
    } // end for i

    //display the String array elements
    for ( int j = 0; j < linesOfCode.length; j++ ) {
      System.out.println( sixSpaces + quote + linesOfCode[j] + quote + ',' );
    } // end for j

    //display the lines after the String array elements
    for ( int k = 14; k < linesOfCode.length; k++ ) {
      System.out.println( linesOfCode[k] );
    } // end for k

  } // end main()

} // end class ProgramThatDisplaysItself
