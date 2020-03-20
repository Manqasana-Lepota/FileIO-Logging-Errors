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

    //declaring instance variables and assigning
    private static String firstName = "Manko";
    private static String lastName = "Lepota";
    private static String fullName = firstName +" "+ lastName;
    private static int age = 30;
    private static LocalDate dateOfVisit = java.time.LocalDate.now();
    private static LocalTime timeOfVisit = java.time.LocalTime.now();
    private static String comments = "Signing the contact";
    private static String personAssists = "Albert Legodi";

    static Scanner kb = new Scanner(System.in);
    static String filename;

    private static Logger logger = LogManager.getLogger(Visitor.class.getName());


    public static void main(String[]args){
        save("");//calling method save()
        System.out.println();//new line
        load();//calling method load()

    }
    public static String save(String s){
        try
        {
            //creating a file
            File file = new File("visitor_" + fullName.replace(" ","-").toLowerCase()+ ".txt");

            //It check the file,
            if(file.createNewFile()) {
                //If file not exists will print this statement
                logger.debug("Successfully created a File !! " + file.getName());
            }
            else {
                //if file exists will print the else statement
                logger.warn("The file already exists");
            }

            //next line
            System.out.println();

            //Displaying message
            System.out.println("Writing on a File........");

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
            logger.info("Successfully saved !!");


        } catch (IOException e) {
            logger.error("An error occurred" + e.getMessage());
        }

        return s;
    }
    public static void load() {
        try {


            //Prompting for user to enter the file name
            System.out.println("Please enter the file you want to read from :");
            filename = kb.nextLine();//read input from the user

            //opening the file for reading
            File inputFile = new File(filename);

            kb = new Scanner(inputFile);

            //Displaying message
            System.out.println("*********Reading From a File***********");

            //next line
            System.out.println();

           //Reading all the lines from a file
            while(kb.hasNext()) {

                //Reading a line from a file
               String lines = kb.nextLine();

               //printing the lines
               System.out.println(lines);

           }
           kb.close();//closing the file


        } catch (FileNotFoundException e) {
            logger.error("File not Found" + e.getMessage());
        }

    }
}
