import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program uses recursion to calculate
 * a power to a number.
 *
 * @author  Melody Berhane
 * @version 1.0
 *
 * @since 2023-04-25.
 */

public final class RecPow {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecPow() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            // Create an ArrayList to hold the values.
            final ArrayList<String> inputList = new ArrayList<String>();

            while (sc.hasNextLine()) {
                // Read line as string.
                final String line = sc.nextLine();
                inputList.add(line);
                for (String input : inputList) {
                    try {
                        // Split the input into base and exponent.
                        final String[] inputParts = input.split(" ");

                        // Parse the input to integers
                        final int base = Integer.parseInt(inputParts[0]);
                        final int exponent = Integer.parseInt(inputParts[1]);

                        if (base >= 1 && exponent >= 0) {
                            // call the function to call the power.
                            final int recPower = recPow(base, exponent);

                            // Write to output file
                            write.print("The number " + base);
                            write.print("^" + exponent);
                            write.print(" is = " + recPower);
                        } else {
                            write.println("Please enter a positive number.");
                        }

                    } catch (NumberFormatException error) {
                        // Displays error to user if input is not a valid int.
                        write.println("Error: Invalid, \""
                                + line + "\" is not a valid number.");
                    }
                }
            }
            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * calculate a power to a number.
    *
    * @param base passed
    * @param exponent passed
    * @return recPow.
    */

    public static int recPow(int base, int exponent) {
        // Calculates power of a number.
        if (exponent == 0) {
            // Returns 1 because anything to the power of 0 is 1
            return 1;
        } else {
            // Calls function recursively.
            return base * recPow(base, exponent - 1);
        }
    }
}
