package catalog;

import java.util.Scanner;

/**
 * This class allows the user to interact with the system
 * using keyboard input.
 */
public class UserInterface {
    public final static String CHECKOUT = "1";
    public final static String RETURN = "2";
    public final static String PRINT_AVAILABLE = "3";
    public final static String EXIT = "4";

    /**
     * The method interacts with the user allowing them
     * to checkout a book, to return a book, to see a list
     * of available books, and to exit the program.
     *
     * @param lc Library Catalog
     */
    public void mainLoop(LibraryCatalog lc) {
        // FILL IN CODE
        // Repeatedly prompt the user:
        // To check out a book, enter 1
        // To return a book, enter 2
        // To see a list of books currently available, enter 3
        // To exit, enter 4

        Scanner input = new Scanner(System.in);

        String repeat;


        boolean checkedOut;
        boolean returned;


        // figure out how to say if book with title available or not
        // do same for return book - success message?

        String selection;
        do {
            for (int i = 0; i < lc.books.size(); i++) {
                System.out.println(lc.books.get(i));
            }
            System.out.println("  ");
            System.out.println("To check out a book, enter 1");
            System.out.println("To return a book, enter 2");
            System.out.println("To see a list of books currently available, enter 3");
            System.out.println("To exit, enter 4");


            repeat = input.nextLine();
            if (repeat.equals("1")) {
                System.out.println("Type in the title you'd like to check out then press 'Enter': ");
                selection = input.nextLine();
                checkedOut = lc.checkoutBook(selection);
                if (checkedOut == true) {
                    System.out.println("You have successfully checked out " + "\"" + selection + "\"");

                } else {
                    System.out.println("Sorry, this title is currently unavailable.");
                }

            } else if (repeat.equals("2")) {
                System.out.println("Type in the title of the book you'd like to return then press 'Enter'. If it is currently checked out, it will be returned.");
                selection = input.nextLine();
                returned = lc.returnBook(selection);
                if (returned == true) {
                    System.out.println("You have successfully returned " + "\"" + selection + "\"");
                } else {
                    System.out.println("This title is not currently checked out.");
                }
            } else if (repeat.equals("3")) {
                System.out.println(lc.getAvailableBooks());
            } else if (repeat.equals("4")) {
                System.out.println("Program exited.");
                break;
            }

            System.out.println("--------------------------------------------------------");
        } while (!repeat.equals("4"));

        // If the user enters 1, ask for the title, and if the book is available,
        // check it out

        // If the user enters 2, ask for the title, and if the book is currently
        // checked out, return it.

        // If a user enters 3, display all the books that are currently
        // available (not checked out).

        // If a user enters 4, exit the program


    } // mainLoop
}
