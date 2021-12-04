// Completed Task 1: Update code style for better consistency.
// Completed Task 2: Fixed early terminates for passing wrong number of argument,
// Completed Task 3: Makes improvement in variable names

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

    public static void main(String[] args) {

        // Check arguments
        if (args.length==0){
            System.out.println("You must have to put at least one argument.");
        }

        else if (args.length>1){
            System.out.println("Multipled arguments found ! You must have to put exactly one argument to run this program.");

        }

        else if (args[0].length()>1){
            System.out.println("Please pass the correct argument.");

        }


        else if (args[0].equals("a")) {

            System.out.println("Loading data ...");

            try {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));

                String lines = bufferedReader.readLine();
                String[] studentNames = lines.split(",");

                for (String name : studentNames) {
                    System.out.println(name);
                }

            }

            catch (Exception e) {

            }

            System.out.println("Data Loaded.");
        }

        else if (args[0].equals("r")) {

            System.out.println("Loading data ...");

            try {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));

                String lines = bufferedReader.readLine();
                System.out.println(lines);

                String[] studentNames = lines.split(",");

                Random random = new Random();
                int indexOfRandomStudent = random.nextInt();

                System.out.println(studentNames[indexOfRandomStudent]);

            }

            catch (Exception e) {

            }

            System.out.println("Data Loaded.");
        }

        else if (args[0].contains("+")) {

            System.out.println("Loading data ...");

            try {

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));

                String newStudentName = args[0].substring(1);
                Date todaysDate = new Date();

                String formatedDateString = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(formatedDateString);

                String currentDateTime = dateFormat.format(todaysDate);
                bufferedWriter.write(", " + t + "\nList last updated on " + currentDateTime);
                bufferedWriter.close();
            }

            catch (Exception e) {

            }

            System.out.println("Data Loaded.");

        }


        else if (args[0].contains("?")) {

            System.out.println("Loading data ...");

            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));

                String lines = bufferedReader.readLine();
                String[] studentNames = lines.split(",");

                boolean isFound = false;

                String studentName = args[0].substring(1);

                for (int idx = 0; idx < studentNames.length && !isFound; idx++) {
                    
                    if (studentNames[idx].equals(studentName)) {
                        System.out.println("We found it!");
                        isFound = true;
                    }
                
                }
                
            }

            catch (Exception e) {

            }

            System.out.println("Data Loaded.");
        }

        else if (args[0].contains("c")) {

            System.out.println("Loading data ...");

            try {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));

                String lines = bufferedReader.readLine();

                char[] letters = lines.toCharArray();
                boolean in_word = false;

                int count = 0;

                for (char c : letters) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        }

                        else {
                            in_word = false;
                        }
                    }
                }

                System.out.println(count + " word(s) found " + letters.length);
            }

            catch (Exception e) {

            }

            System.out.println("Data Loaded.");

        }
    }
}