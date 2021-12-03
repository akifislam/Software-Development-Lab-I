// Completed Task 1: Update code style for better consistency.
// Completed Task 2: Fixed early terminates for passing wrong number of argument,
// Completed Task 3: Makes improvement in variable names
// Completed Task 4 : Refactors Duplicates File Read and write logic into method.

package Akif;


import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

    static BufferedReader bufferedReader;
    static String lines;
    public static void getReader(){

        try {
           bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            lines = bufferedReader.readLine();
        }

        catch (FileNotFoundException e) {
            System.out.println("File cannot be opened !");
        }
       catch (IOException e) {
            System.out.println("Empty File");
        }

    }

    public static void main(String[] args) {
        getReader();

        // Check arguments

        if (args.length == 0) {
            System.out.println("You must have to put at least one argument.");
        }

        else if (args.length > 1) {
            System.out.println("Multipled arguments found ! You must have to put exactly one argument to run this program.");

        }

        else if (!args[0].startsWith("+") && args[0].length() > 1) {
            System.out.println("Please pass the correct argument.");

        }

        else if (args[0].equals("a")) {

            System.out.println("Loading data ...");

            try {

                String[] studentNames = lines.split(",");

                for (String name : studentNames) {
                    System.out.println(name);

                }

            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {

            System.out.println("Loading data ...");

            try {


                System.out.println(lines);

                String[] studentNames = lines.split(",");

                Random random = new Random();
                int indexOfRandomStudent = random.nextInt();

                System.out.println(studentNames[indexOfRandomStudent]);

            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {

            System.out.println("Loading data ...");

            try {


                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));

                String newStudentName = args[0].substring(1);
                Date todaysDate = new Date();

                String formatedDateString = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(formatedDateString);

                String currentDateTime = dateFormat.format(todaysDate);
                bufferedWriter.write(", " + newStudentName + "\nList last updated on " + currentDateTime);
                bufferedWriter.close();

            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");

        } else if (args[0].contains("?")) {

            System.out.println("Loading data ...");

            try {

                String[] studentNames = lines.split(",");

                boolean isFound = false;

                String studentName = args[0].substring(1);

                for (int idx = 0; idx < studentNames.length && !isFound; idx++) {

                    if (studentNames[idx].equals(studentName)) {
                        System.out.println("We found it!");
                        isFound = true;
                    }

                }


            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {

            System.out.println("Loading data ...");

            try {


                char[] letters = lines.toCharArray();

                boolean in_word = false;

                int count = 0;


                for (char letter : letters) {

                    if (letter == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }


                System.out.println(count + " word(s) found " + letters.length);
            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");

        } else {
            System.out.println("Wrong argument. Please put the correct argument");
        }
    }
}