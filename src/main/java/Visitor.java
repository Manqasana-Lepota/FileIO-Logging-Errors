import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class Visitor {

    private static String firstName;
    private static String lastName;
    private static String fullName;
    private static int age;
    private static LocalDate dateOfVisit = java.time.LocalDate.now();
    private static LocalTime timeOfVisit = java.time.LocalTime.now();
    private static String comments;
    private static String personAssists ;

    private static Logger logger = LogManager.getLogger(Visitor.class.getName());
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        char repeat = 0;
        String input;
        Scanner sc = new Scanner(System.in);

        do {
            //Menu options
            System.out.println("*********************************");
            System.out.println("*   Umuzi Management Systems     *");
            System.out.println("*********************************");
            System.out.println("*       1. Save                  *");
            System.out.println("*       2. Load                  *");
            System.out.println("*********************************");
            System.out.println("Enter Your Menu Choice: ");
            choice = sc.nextInt();


            switch (choice) {

                case 1:
                    save(fullName);
                    break;
                case 2:
                    load(fullName);
                    break;

                default:
                    System.out.println("Invalid menu choice , try again.");
                    break;
            }
            System.out.println();
            System.out.println("Would you like to save or load visitor information again ?");
            System.out.println("Enter Y for yes or N for no :");
            input = sc.next();
            repeat = input.charAt(0);



        }while (repeat == 'Y' || repeat == 'y');
    }




    public static String save(String visitor) {

        System.out.println("*************visitor's information*******************:");

        //prompting the user to enter visitor information
        System.out.println("Please enter your first name : ");
        firstName = sc.next();

        System.out.println("Last Name : ");
        lastName = sc.next();

        System.out.println("Age : ");
        age = sc.nextInt();

        System.out.println("Comment : ");
        comments = sc.next();

        System.out.println("Person Assists : ");
        personAssists = sc.next();


        fullName = firstName + " " + lastName;

        System.out.println();

        try {
            File file = new File("visitor_" + fullName.replace(" ", "-").toLowerCase() + ".txt");
            if (file.createNewFile()) {
                //If file not exists will print this statement
                logger.debug("Successfully created a File !! ");
            } else {
                //if file exists will print the else statement
                logger.warn("The file already exists");
            }

            System.out.println();


            //Opening a file to write
            FileWriter writer = new FileWriter(file);
            writer.write("Full Name: " + fullName + "\n");
            writer.write("Age : " + age + "\n");
            writer.write("Date Of Visit : " + dateOfVisit + "\n");
            writer.write("Time of Visit : " + timeOfVisit + "\n");
            writer.write("Comments : " + comments + "\n");
            writer.write("Person Assisted : " + personAssists + "\n");

            //close the file
            writer.close();

            //next line
            System.out.println();

            //Displaying message
            logger.info("Successfully saved !!" + file.getName());

        } catch (IOException e) {
            logger.error("An error occurred" + e.getMessage());
        }
        return visitor;


    }

    public static String load(String visitor) {
        String filename;
        try {
            //Prompting for user to enter the file name
            System.out.println("Please enter the file you want to read from :");
            filename = sc.next();//read input from the user
            System.out.println();

            //opening the file for reading
            File inputFile = new File(filename);

            sc = new Scanner(inputFile);

            //Displaying message
            logger.info("Reading From a File...");

            //next line
            System.out.println();

            //Reading all the lines from a file
            while(sc.hasNext()) {

                //Reading a line from a file
                String lines = sc.nextLine();

                //printing the lines
                System.out.println(lines);

            }
            sc.close();//closing the file


        } catch (FileNotFoundException e) {
            logger.error("File not Found" + e.getMessage());
        }
        return visitor;

    }
}
