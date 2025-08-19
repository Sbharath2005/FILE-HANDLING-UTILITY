import java.io.*;
import java.util.Scanner;

public class FileHandler {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        
        try {
            // 1. Write to a file
            FileWriter writer = new FileWriter(fileName);
            writer.write("Hello, this is the first line.\n");
            writer.write("This is the second line.\n");
            writer.close();
            System.out.println("File written successfully!");

            // 2. Read the file
            System.out.println("\nReading file contents:");
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // 3. Modify (append new content)
            FileWriter appender = new FileWriter(fileName, true); // true → append mode
            appender.write("This is an appended line.\n");
            appender.close();
            System.out.println("\nContent appended successfully!");

            // 4. Display final content
            System.out.println("\nFinal File Content:");
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
