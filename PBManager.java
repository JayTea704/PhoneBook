import java.util.Scanner;

public class PBManager {
    public listNode front;

    public Scanner input;

    public String name;
    public String phone;
    public String address;
    public String city;

    public PBManager(Scanner input) {

        this.input = input;
        front = null;
    }

    //prompts user to fill in values of contact
    public void fillInContact(){

        System.out.println("Name:");
        input.nextLine();
        name = input.nextLine();

        System.out.println("Phone Number:");
        phone = input.nextLine();

        System.out.println("Address:");
        address = input.nextLine();

        System.out.println("City:");
        city = input.nextLine();
    }//end of contact method

    //Prints contact from listNode to console
    public void printContact(listNode current) {

        System.out.println();
        System.out.println("Name: " + current.name);
        System.out.println("Phone: " + current.phone);
        System.out.println("Address: " + current.address);
        System.out.println("City: " + current.city);
        System.out.println();

    }// end of printContact method

    //adds a node for a single contact
    public void add() {

        fillInContact(); //prompts user

        listNode temp = front;
        listNode added = null;

        //if else statement checks to make sure no node is overwritten.
        if(front == null) {

            front = new listNode(name, phone, address, city);
            added = front;
        }
        else {
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new listNode(name, phone, address, city);
        }

        System.out.println();
        System.out.println("Contact added to Phone Book");

        printContact(added); //prints to console

    } //end of add method

    //removes specific contact node
    public void remove() {
        System.out.println("Input name, phone, address, and city of contact you want to remove");

        fillInContact(); //prompts user to give exact contact

        try {

            listNode current = front;
            listNode prev = null;

            // checks to make sure inputted values match a contact
            if (current.name.equalsIgnoreCase(name) && current.phone.equalsIgnoreCase(phone) && current.address.equalsIgnoreCase(address) && current.city.equalsIgnoreCase(city)) {

                front = current.next;
                return;
            }

            while (current != null && (!(current.name.equalsIgnoreCase(name)) || !(current.phone.equalsIgnoreCase(phone)) || !(current.address.equalsIgnoreCase(address)) || !(current.city.equalsIgnoreCase(city)))) {

                prev = current;
                current = current.next;
            }

            prev.next = current.next; //remove contact by rotating next contact to its place
            System.out.println();
            System.out.println("Contact removed");
        }

        catch (NullPointerException nullPoint){ //catches if contact is not in listNode

            System.out.println();
            System.out.println("Contact does not exist");
            System.out.println();
        }
    } //end of remove method

    public void change(){ //changes single piece of contact
        System.out.println("Type name, phone, address, and city of contact you want to change");

        fillInContact();

        try {

            System.out.println("What do you want to change");
            System.out.println("name (n), phone (p), address (a), or city (c)");

            String answer = input.next();

            listNode current = front;

            while (current != null && (!(current.name.equals(name)) || !(current.phone.equals(phone)) || !(current.address.equals(address)) || !(current.city.equals(city)))) {

                current = current.next;
            }
            switch (answer) {

                case "n":

                    System.out.println("What would you like to change it to");
                    input.nextLine();
                    answer = input.nextLine();

                    if (current.name.equals(name) && current.phone.equals(phone) && current.address.equals(address) && current.city.equals(city)) {

                        current.name = answer;
                    }

                    break;

                case "p":

                    System.out.println("What would you like to change it to");
                    input.nextLine();
                    answer = input.nextLine();
                    current.phone = answer;

                    break;

                case "a":

                    System.out.println("What would you like to change it to");
                    input.nextLine();
                    answer = input.nextLine();
                    current.address = answer;

                    break;

                case "c":

                    input.nextLine();
                    System.out.println("What would you like to change it to");
                    answer = input.nextLine();
                    current.city = answer;

                    break;
            }

            printContact(current);
        }

        catch(NullPointerException nullPoint){ //catches if contact is not in listNode

            System.out.println();
            System.out.println("Contact does not exist");
            System.out.println();
        }
    } //end of change method

    //prints each entry in phone book
    public void printBook() {
        System.out.println();
        System.out.println("Phone Book:");
        System.out.println();

        listNode current = front;

        if(current == null){

            System.out.println("No contacts in Phone Book");
            System.out.println();
        }

        // Loops through every contact.
        while(current != null){

            System.out.println("Name: " + current.name);
            System.out.println("Phone: " + current.phone);
            System.out.println("Address: " + current.address);
            System.out.println("City: " + current.city);
            System.out.println();

            current = current.next;
        }
    } //end of printBook method

} //end of PBManager class
