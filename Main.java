//Programmer: John Bedlington
//Date: 2/5/2023
//Class: CS &145
//Assignment: #2
//This program will make a phonebook allowing users to create and modify entries

import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        Scanner input = new Scanner(System.in);
        PBManager book = new PBManager(input);
        boolean ask = true;

        //While loop to run until user decides to quit
        while(ask) {

            System.out.println("add contact (a)");
            System.out.println("remove contact (r)");
            System.out.println("change contact (c)");
            System.out.println("Display phone book (p)");
            System.out.println("Close phone book (q)");

            String answer = input.next();

            switch (answer) {
                case "a": book.add(); break;
                case "r": book.remove(); break;
                case "c": book.change(); break;
                case "p": book.printBook(); break;
                case "q": ask = false; break;
                //catch in case of invalid input
                default:

                    System.out.println();
                    System.out.println("Invalid command. Please choose from list of commands");
                    System.out.println();
            }//end of switch case
        }//end of while loop

    }//end of main method
}//end of Main class
