// Completed Task 1: Update code style for better consistency.
// Completed Task 2: Fixed early terminates for passing wrong number of argument,
// Completed Task 3: Makes improvement in variable names
// Completed Task 4 : Refactors Duplicates File Read and write logic into method.
// Completed Task 5 : Replace String Literals with Constant.java Class
// Completed Task 6 : Remove Temporary Variable
// Completed Task 7 : Elimates 'Done' and adds better response for search operation

import java.io.*;
import java.text.*;
import java.util.*;


public class StudentList {

    static BufferedReader bufferedReader;
    static String lines;
    static String [] studentNames;
    public static void getReader(){

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            lines = bufferedReader.readLine();
            studentNames = lines.split(",");
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

        else if (!args[0].startsWith("@") && !args[0].startsWith("+") && args[0].length() > 1) {
//            System.out.println("LFLFLFLF");
            System.out.println(Constants.WrongArgument);

        }

        else if (args[0].equals("a")) {

            System.out.println(Constants.DataLoadingProgress);

            try {

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

                Random random = new Random();
                int indexOfRandomStudent = random.nextInt();

                System.out.println(studentNames[indexOfRandomStudent]);

            } catch (Exception e) {

            }

            System.out.println(Constants.DataLoadSucessMsg);
        }

        else if (args[0].contains("+")) {


            try {


                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));

                String newStudentName = args[0].substring(1);
                Date todaysDate = new Date();

                String formatedDateString = Constants.formatedDateString;
                DateFormat dateFormat = new SimpleDateFormat(formatedDateString);

                String currentDateTime = dateFormat.format(todaysDate);
                bufferedWriter.write(newStudentName + " (Added on " + currentDateTime+ "),");
                System.out.println("New Data Added.");
                bufferedWriter.close();

            } catch (Exception e) {
                System.out.println("Could not add new data");
            }



        } else if (args[0].contains("@")) {

            System.out.println(Constants.DataLoadingProgress);

            try {

                String studentName = args[0].substring(1);

                for (int idx = 0; idx < studentNames.length; idx++) {

                    if (studentNames[idx].startsWith(studentName)) {
                        System.out.println(Constants.FoundYesMessage);
                        System.out.println(Constants.DataLoadSucessMsg);
                        return;
                    }

                }

                System.out.println(Constants.FoundNoMessage);


            } catch (Exception e) {

            }

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
