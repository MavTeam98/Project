import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;


public class Project {


    public static class GpaCalculator {

        public static void mainMenu() throws IllegalArgumentException
        {
            Scanner scanner = new Scanner(System.in);
            boolean flag = false;
            String choice;
            do {
                System.out.println("-GPA Calculator Main Menu-");
                System.out.println("A - add semester");
                System.out.println("B - remove semester");
                System.out.println("C - show all semesters entered");
                System.out.println("D - quit");
                System.out.print("Enter choice: ");
                choice = scanner.next();

                try
                {
                    switch (choice) {
                        case "A":
                            addSemester();
                            break;
                        case "a":
                            addSemester();
                            break;
                        case "B":
                            removeSemester();
                            break;
                        case "b" :
                            removeSemester();
                            break;
                        case "C":
                            printSemesters();
                            break;
                        case "c":
                            printSemesters();
                            break;
                        case "D":
                            flag = true;
                            break;
                        case "d":
                            flag = true;
                            break;
                        default:
                            throw new IllegalArgumentException();

                    }
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println("Invalid menu choice, try again.");
                }

            }
            while (!flag);



        }

        static final ArrayList<String> StoredGPAs = new ArrayList<String>();

        public static void addSemester()
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


            System.out.print("What semester do you want to input? (fall 2020, spring 2019, etc): ");
            String semester = scanner.nextLine();                                                       // storing semester that the user wants to input grades for

            System.out.print("Enter the number of classes taken: ");
            int numClasses = scanner.nextInt();                                                         // prompting user for how many classes they wish to enter grades for, for desired semester



            for (int i = 0; i < numClasses; i++) {

                try
                {
                    System.out.print("Please enter the letter grade for class " + (i+1) + ": ");
                    lettergrd = grd.next();                                                             // storing letter grade from user input for class num i+1

                    System.out.print("Please enter the number of credits the course gives: ");
                    credit = grd.nextDouble();                                                          // storing credits that can be earned from that class
                    if (credit > 4 || credit < 1)                                                       // checking user input if the inputted credits is valid
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
                    System.out.println("Error: Invalid letter grade entered.");
                    System.exit(-1);                                    // exits the program due to error
                }
                catch (InvalidAlgorithmParameterException e)                    // same as above except this is for the invalid credits entered error
                {
                    System.out.println("Error: Invalid credits entered.");
                    System.exit(-1);
                }



            }

            finalgpa = totalcal / totalcredit;                                      // calculates overall gpa for the given semester
            System.out.println("GPA for semester "+ semester + ": " + df.format(finalgpa));     //shows the user the overall gpa they achieved for the given semester
            System.out.println("\n");
            String semesterGPA = semester + ": " + df.format(finalgpa);         // stores users gpa/semester string into a variable

            System.out.print("Would you like to store this semesters GPA?(y or n): ");
            String choice = scanner.next();
            switch (choice)
            {
                case "y":
                    StoredGPAs.add(semesterGPA);
                    System.out.println("Semester successfully stored.\n");
                    break;
                case "Y":
                    StoredGPAs.add(semesterGPA);
                    System.out.println("Semester successfully stored.\n");
                    break;
                case "n":
                    System.out.println("Semester not stored...\n");
                    break;
                case "N":
                    System.out.println("Semester not stored...\n");
                    break;
            }
        }

        public static void removeSemester()
        {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter semester to remove (fall 2020: 4, spring 2019: 3.51, etc) : ");
            String semester = scanner.nextLine();

            if (!StoredGPAs.contains(semester))
            {
                System.out.println("Semester not found.");
            }
            else if(StoredGPAs.contains(semester))
            {
                System.out.println("Semester found, removing...");
                StoredGPAs.remove(semester);
            }

        }

        public static void printSemesters()
        {
            if (StoredGPAs.size() > 0)
            {
                for (String value : StoredGPAs)
                {
                    System.out.println(value);
                    System.out.println("\n");
                }
            }
            else
            {
                System.out.println("No stored semesters found.\n");
            }


        }



        public static void main(String[] args)
        {
            mainMenu();

        }

    }


}
