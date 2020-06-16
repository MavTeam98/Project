import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.util.*;
import java.text.DecimalFormat;


public class Project {


    public static class GpaCalculator {

        public static void mainMenu() throws IllegalArgumentException, InterruptedException           // main menu method to drive the program until input to quit the program is entered
        {

            System.out.println();
            System.out.println("This program is designed to calculate GPA's for semesters.\nWith this information given you can search, sort, remove, or print the stored semesters.");  // describe the program to the user.
            Thread.sleep(1000);
            initializingMenu(3);                             // simple and small recursion to allow the user to read the progams purpose
            Scanner scanner = new Scanner(System.in);           // scanner variable to take user input
            boolean flag = false;                               // flag variable for the quit command in the method
            String choice;                                      // variable to store the user's input
            do {                                                // do/while block to drive the entire program endlessly until user wants to quit
                System.out.println("-GPA Calculator Main Menu-");           // print all menu options
                System.out.println("A - Calculate semester GPA");
                System.out.println("B - remove semester");
                System.out.println("C - show all semesters entered");
                System.out.println("D - sort semesters");
                System.out.println("E - search for a semester");
                System.out.println("F - overall GPA for stored semesters");
                System.out.println("X - quit program");
                System.out.print("Enter choice: ");
                choice = scanner.next();                                    // take in user input

                try                                 // try/catch blocks in case the user enters an invalid option
                {
                    switch (choice) {                       // switch block for all the available options to call that will call the method associated with the menu options
                        case "A" -> GPACalculator();        // each method is explained at the method
                        case "a" -> GPACalculator();
                        case "B" -> removeSemester();
                        case "b" -> removeSemester();
                        case "C" -> printSemesters();
                        case "c" -> printSemesters();
                        case "D" -> StoredSemesters = sortSemesters((HashMap<String, String>) StoredSemesters);
                        case "d" -> StoredSemesters = sortSemesters((HashMap<String, String>) StoredSemesters);
                        case "E" -> searchSemesters();
                        case "e" -> searchSemesters();
                        case "F" -> overallGPA();
                        case "f" -> overallGPA();
                        case "X" -> {
                            System.out.println("Exiting program...");
                            Thread.sleep(1000);
                            flag = true;
                        }
                        case "x" -> {
                            System.out.println("Exiting program...");
                            Thread.sleep(1000);
                            flag = true;
                        }
                        default -> throw new IllegalArgumentException();        // if the user enters a invalid option, throws an error that is caught and tells the user input was invalid and to try again.
                    }
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println("Invalid menu choice, try again.");
                }

            }
            while (!flag);          // while the user doesn't enter e/E the program continues



        }


        static Map<String, String> StoredSemesters = new HashMap<String, String>();  // initializing a package variable to store semesters

        public static void GPACalculator() throws InterruptedException          // method that calculates the gpa based off of some variables the user inputs. built upon the original code provided by Sachini
        {
            String lettergrd;
            double credit;
            double caltimes = 0;
            double totalcal = 0;
            double totalcredit = 0;
            double finalgpa;
            final double A = 4.0;
            final double AMINUS = 3.67;
            final double BPLUS = 3.33;
            final double B = 3.0;
            final double BMINUS = 2.67;
            final double CPLUS = 2.33;
            final double C = 2.0;
            final double CMINUS = 1.67;
            final double D = 1.00;
            final double F = 0.0;

            DecimalFormat df = new DecimalFormat("0.##");
            Scanner grd = new Scanner(System.in);
            Scanner scanner = new Scanner(System.in);


            System.out.print("What semester do you want to calculate? (2020 fall, 2019 spring, etc): ");
            String semester = scanner.nextLine();                                                       // storing semester that the user wants to input grades for. used to reference stored semesters

            System.out.print("Enter the number of classes taken: ");

            int numClasses = scanner.nextInt();                                                         // prompting user for how many classes they wish to enter grades for, for desired semester



            for (int i = 0; i < numClasses; i++) {                                                      // for loop to continue the following code for each class the user has taken

                try
                {
                    System.out.print("Please enter the letter grade for class " + (i+1) + ": ");
                    lettergrd = grd.next();                                                             // storing letter grade from user input for class num i+1

                    System.out.print("Please enter the number of credits the course gives (1-4): ");
                    credit = grd.nextDouble();                                                          // storing credits that can be earned from that class
                    if (credit > 4 || credit < 1)                                                       // checking user input if the inputted credits is valid based off of standard credits
                    {
                        throw new InvalidAlgorithmParameterException();                                 // if not, throw an error that will terminate the program and state why
                    }


                    switch (lettergrd) {                                                                // switch to determine what gpa the user got for the grade and credits possible
                        case "A":
                            caltimes = credit * A;
                        case "a":
                            caltimes = credit * A;
                            break;
                        case "A-":
                            caltimes = credit * AMINUS;
                        case "a-":
                            caltimes = credit * AMINUS;
                            break;
                        case "B+":
                            caltimes = credit * BPLUS;
                        case "b+":
                            caltimes = credit * BPLUS;
                            break;
                        case "B":
                            caltimes = credit * B;
                        case "b":
                            caltimes = credit * B;
                            break;
                        case "B-":
                            caltimes = credit * BMINUS;
                        case "b-":
                            caltimes = credit * BMINUS;
                            break;
                        case "C+":
                            caltimes = credit * CPLUS;
                        case "c+":
                            caltimes = credit * CPLUS;
                            break;
                        case "C":
                            caltimes = credit * C;
                        case "c":
                            caltimes = credit * C;
                            break;
                        case "C-":
                            caltimes = credit * CMINUS;
                        case "c-":
                            caltimes = credit * CMINUS;
                            break;
                        case "D":
                            caltimes = credit * D;
                        case "d":
                            caltimes = credit * D;
                            break;
                        case "F":
                            caltimes = credit * F;
                        case "f":
                            caltimes = credit * F;
                            break;
                        default:
                            throw new InvalidParameterException();                                      // if user inputted a letter of any other kind, throw an error
                    }

                    totalcredit += credit;                                                 // calculating how many credits the user took in given semester
                    totalcal += caltimes;                                         // adding all gpa's inputted for the given semester
                }

                catch (InvalidParameterException e)                             // catch error for invalid letter grade that will print the reason why the program terminated
                {
                    System.out.println("Error: Invalid letter grade entered, try again.");
                    System.out.println();
                    return;                                             // returns the user to the main menu since they entered an invalid letter grade

                }
                catch (InvalidAlgorithmParameterException e)                    // same as above except this is for the invalid credits entered error
                {
                    System.out.println("Error: Invalid credits entered.");
                    System.out.println();
                    return;                                     // same as above return, but if they enter an invalid credit amount.
                }



            }

            finalgpa = totalcal / totalcredit;                                      // calculates overall gpa for the given semester
            System.out.println("GPA for semester "+ semester + ": " + df.format(finalgpa));     //shows the user the overall gpa they achieved for the given semester
            System.out.println("\n");
            String semesterGPA = semester + ": " + df.format(finalgpa);         // stores users gpa/semester string into a variable
            Thread.sleep(1000);

            System.out.print("Would you like to store this semesters GPA?(y or n): ");                          // asking the user if they want to store the semester for reference later
            String choice = scanner.next();
            String gpa = df.format(finalgpa);
            switch (choice) {                                                                                   // switch for the choice the user makes
                case "y" -> addSemester(semester, gpa);                                                         // if y then we call the addsemester method to store it into the package variable StoredSemesters
                case "Y" -> addSemester(semester, gpa);
                case "n" -> System.out.println("Semester not stored...\n");                                     // if n, then we do nothing with it.
                case "N" -> System.out.println("Semester not stored...\n");
                default -> System.out.println("Invalid character entered, recalculate semester if you want to store it.");              // if user inputs invalid option, then nothing happens and we return them to the menu
            }
        }
        public static void addSemester(String semester, String gpa)                         // simple method to add the inputted semester to the package variable StoredSemester
        {

            StoredSemesters.put(semester,gpa);                                  // storing the users semester and associated gpa into the package variable storedsemester
            System.out.println("Semester successfully stored.\n");              // telling the user that we successfully stored the semester



        }

        public static void removeSemester()                                 // method to remove a stored semester from the map of all the stored semesters
        {
            Scanner scanner = new Scanner(System.in);

            if (StoredSemesters.size() > 0)
            {
                System.out.print("Enter semester to remove (2020 fall, 2019 spring etc) : ");             // prompting user to input the semester the want to remove in the specified format
                String semester = scanner.nextLine();                                               // storing users input as a string that we can use

                if (!StoredSemesters.containsKey(semester))                                         // if the users input is not found in the storedsemesters map, then we tell me that we did not find it.
                {
                    System.out.println("Semester not found.");
                }
                else if(StoredSemesters.containsKey(semester))                                      // but if it is in the storedsemesters map, we then tell the user we found it and are removing it
                {
                    System.out.println("Semester found, removing...");
                    StoredSemesters.remove(semester);                                               // removing desired semester from the map.
                }
            }
            else
            {
                System.out.println("No semesters stored to remove!");
                System.out.println();
            }



        }

        public static void printSemesters()                                 // method to print all semesters that have been stored
        {
            if (StoredSemesters.size() > 0)                                 // checking if any semesters have been stored
            {
                for (Map.Entry value : StoredSemesters.entrySet())          // if there is atleast one or more semester stored, we then for loop through each key/value and print it out in the stated format.
                {
                    Object temp = value.getKey();
                    String gpa = (String) value.getValue();
                    System.out.println("Semester: " + temp + " GPA: " + gpa + "\n");
                }


            }
            else                                                            // if no semesters are currently stored, we tell the user no stored semesters
            {
                System.out.println("No stored semesters found.\n");
            }



        }
        public static void searchSemesters()                        // method that searches the stored semesters for an inputted semester and then prints the semester gpa if found
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the semester to search for (2019 fall, 2020 spring, etc): ");
            String toSearch = scanner.nextLine();

            if (StoredSemesters.size() > 0)
            {
                if (StoredSemesters.containsKey(toSearch))                                              // if the inputted semester is found, print it out
                {
                    System.out.println("Semester found: " + toSearch + ": " + StoredSemesters.get(toSearch) + " GPA");
                    System.out.println();
                }
                else                                                                                    // if it is not found, tell the user it was not found
                {
                    System.out.println("Semester not found.");
                    System.out.println();
                }
            }
            else
            {
                System.out.println("No stored semesters to search!");
                System.out.println();
            }


        }

        public static Map<String, String> sortSemesters(HashMap<String, String> inputMap)               // method to take the package map, storedsemesters, and sort it.
        {
            System.out.println();
            if (inputMap.size() > 0)                                                                    // if there is atleast 1 semester stored, we return a Treemap, that automatically sorts the map by keys.
            {
                System.out.println("Sorting semesters...");
                System.out.println();
                return new TreeMap<String, String>(inputMap);
            }
            else                                                                                        // else, we tell the user there are no semesters to sort and just return the inputted map
            {
                System.out.println("No stored semesters to sort!");
                System.out.println();
                return inputMap;
            }

        }

        public static void initializingMenu(int n) throws InterruptedException                          // simple/small recursion method to all the user to read the description of the program before the menu is shown.
        {
            if (n == 0)
            {
                System.out.println("Initializing Menu...");
                Thread.sleep(1000);
            }
            else
            {
                System.out.println(n);
                Thread.sleep(1000);
                initializingMenu((n-1));
            }
        }

        public static void overallGPA()
        {

            if (StoredSemesters.size() > 0)
            {
                int numGPAS = StoredSemesters.size();
                double sumOfCredits = 0;
                for (Map.Entry value : StoredSemesters.entrySet())
                {
                    String stringtemp = (String) value.getValue();
                    double temp = Double.parseDouble(stringtemp);
                    sumOfCredits += temp;
                }
                double finalgpa = sumOfCredits / numGPAS;


                System.out.println("Total GPA from all semesters stored: " + finalgpa);
                System.out.println();
            }
            else
            {
                System.out.println("No semesters stored!");
                System.out.println();
            }


        }


        public static void main(String[] args)  throws InterruptedException             // main method to run the program.
        {
            mainMenu();

        }

    }


}
