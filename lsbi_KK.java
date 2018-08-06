/*
Kurt Kaiser
CTIM 168
07.28.2018
Homework: Steganography
 */

import java.io.*;
import java.util.Scanner;

public class lsbi_KK {

    public static void main(String[] args) {
        //File stage = new File ("stage.txt");
           String fileName = "stage.txt";
           PrintWriter outputStream = null;
            String[] data = new String[100];
            String line = "";
            int count = 0;
        try {
            Scanner inputStream = new Scanner(new File("binary.txt"));
            outputStream = new PrintWriter(fileName);
            while (inputStream.hasNextLine()) {
                // Scan each line of file into a string array
                data[count] = inputStream.nextLine();
                // Get last character of each line and add to string line
                line += data[count].charAt(14);
                // Output to document once line is 8 characters
                if ((count+1) % 8 == 0) {
                    outputStream.println(line);
                    line = "";
                }
                count++;
            }
        } catch (FileNotFoundException e){
            System.out.println("Error opening the file " + fileName);
            System.exit(0);

        }
        // Output final line to the file, in case final line not 8 characters
        outputStream.println(line);
        outputStream.close();
    }
}
