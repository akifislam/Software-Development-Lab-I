// Completed Task 1: Update code style for better consistency.
// Completed Task 2: Fixed early terminates for passing wrong number of argument,
// Completed Task 3: Makes improvement in variable names
// Completed Task 4 : Refactors Duplicates File Read and write logic into method.
// Completed Task 5 : Replace String Literals with Constant.java Class


import java.io.*;
import java.text.*;
import java.util.*;

public class Constants{

    public static String FileIOExMessage = "Can't open file. File is missing or damaged.";
    public static String IOExMessage = "The file is empty.";
    public static String ZeroArgument = "No argument found. Please put a argument (a/r/c/+name/?name)";
    public static String MultipleArgument = "More than 1 argument found. Please put exactly 1 argument (a/r/c/+name/?name)";
    public static String WrongArgument = "Wrong argument passed. Please put (a/r/c/+name/?name)";
    public static String formatedDateString = "dd/mm/yyyy-hh:mm:ss a";
    public static String FoundYesMessage = "Yes ! We found it.";
    public static String IOExMessage = "The file is empty.";
    public static String DataLoadSucessMsg = "Data Loaded Successfully !";
    public static String DataLoadingProgress = "Data Loading . . . ";

}

public class StudentList {

    static BufferedReader bufferedReader;
    static String lines;
    public static void getReader(){

        try {
           bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            lines = bufferedReader.readLine();
        }

        catch (FileNotFoundException e) {
            System.out.println(Constants.FileIOExMessage);
        }
       catch (IOException e) {
            System.out.println(Constants.IOExMessage);
        }

    }

    public static void main(String[] args) {
        getReader();

        // Check arguments

        if (args.length == 0) {
            System.out.println(Constants.ZeroArgument);
        }

        else if (args.length > 1) {
            System.out.println(Constants.MultipleArgument);

        }

        else if (!args[0].startsWith("+") && args[0].length() > 1) {
            System.out.println(Constants.WrongArgument);

        }

        else if (args[0].equals("a")) {

            System.out.println(Constants.DataLoadingProgress);

            try {

                String[] studentNames = lines.split(",");

                for (String name : studentNames) {
                    System.out.println(name);

                }

            } catch (Exception e) {

            }

            System.out.println(Constants.DataLoadSucessMsg);
        } else if (args[0].equals("r")) {

            System.out.println(Constants.DataLoadingProgress);

            try {


                System.out.println(lines);

                String[] studentNames = lines.split(",");

                Random random = new Random();
                int indexOfRandomStudent = random.nextInt();

                System.out.println(studentNames[indexOfRandomStudent]);

            } catch (Exception e) {

            }

            System.out.println(Constants.DataLoadSucessMsg);
        } else if (args[0].contains("+")) {

            System.out.println(Constants.DataLoadingProgress);

            try {


                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));

                String newStudentName = args[0].substring(1);
                Date todaysDate = new Date();

                DateFormat dateFormat = new SimpleDateFormat(Constants.formatedDateString);

                String currentDateTime = dateFormat.format(todaysDate);
                bufferedWriter.write(", " + newStudentName + "\nList last updated on " + currentDateTime);
                bufferedWriter.close();

            } catch (Exception e) {

            }

            System.out.println(Constants.DataLoadSucessMsg);

        } else if (args[0].contains("?")) {

            System.out.println(Constants.DataLoadingProgress);

            try {

                String[] studentNames = lines.split(",");

                boolean isFound = false;

                String studentName = args[0].substring(1);

                for (int idx = 0; idx < studentNames.length && !isFound; idx++) {

                    if (studentNames[idx].equals(studentName)) {
                        System.out.println(Constants.FoundYesMessage);
                        isFound = true;
                    }

                }


            } catch (Exception e) {

            }

            System.out.println(Constants.DataLoadSucessMsg);
        } else if (args[0].contains("c")) {

            System.out.println(Constants.DataLoadingProgress);

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

            System.out.println(Constants.DataLoadSucessMsg);

        } else {
            System.out.println(Constants.WrongArgument);
        }
    }
}
