package catalog;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * LibraryCatalog Class - represents a collection of books,
 * where each book can be "checked out" and "returned".
 */
public class LibraryCatalog {

    /* ArrayList to store the books in the catalog. Remember to
    initialize this array in the constructor of the class. */
    public ArrayList<Book> books;

    /**
     * Constructor for LibraryCatalog
     */
    public LibraryCatalog() {
        // FILL IN CODE: initialize the ArrayList books here

        books = new ArrayList<>();

    }

    /**
     * Adds a book to the ArrayList of books.
     *
     * @param book book to be added to the catalog
     */
    public void addBook(Book book) {
        // FILL IN CODE
        books.add(book);

    }


    /**
     * Searches for the book with the given title in the ArrayList
     * "books" and returns the book. Returns null if there is no book
     * with this title.
     *
     * @param title title of the book
     * @return reference to the Book with the given title
     */
    public Book findBook(String title) {
        // FILL IN CODE


        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getTitle().equals(title)) {
                return books.get(i);
            }

        }
        return null; // remember to change it
    }

    /**
     * Checks out the book with the given title from the library.
     * First, searches for the book with the given title, and then
     * checks it out (by calling the corresponding method in class Book)
     * if it is not currently checked out. The method returns true if it
     * was able to check out the book, otherwise false.
     *
     * @param title title of the book
     * @return true if was able to checkout a book, false otherwise
     */
    public boolean checkoutBook(String title) {

        // FILL IN CODE

        Book wantedBook = findBook(title);

        if (wantedBook == null) {
            return false;
        }


        return wantedBook.checkoutBook();

    }

    /**
     * Returns the book with the given title to the library. If the
     * book is in the ArrayList of books, has the matching title and is
     * currently checked out, the method is going to "return" it (by
     * calling the returnBook() method of class Book.
     *
     * @param title title of the book to return
     * @return true if was able to return the book, false otherwise
     */
    public boolean returnBook(String title) {
        // FILL IN CODE

        Book returningBook = findBook(title);
        if (returningBook != null) {
            return returningBook.returnBook();
        }


        return false; // remember to change it
    }

    /**
     * Reads the file with the given filename line by line;
     * extracts book title, author, year and average rating from each line;
     * creates a Book object, and adds it to the ArrayList of books.
     *
     * @param filename name of the file that contains books info
     */
    public void addBooksFromFile(String filename) {
        try {

            // FILL IN CODE
            // You can use Scanner or BufferedReader to read from the file.
            // To split the line into individual words (title, author, year, averageRating),
            // use line.split(",").

            // To convert a String into an integer for the
            // variable "year", you can use Integer.parseInt(String s) function.
            // You are required to catch FileNotFoundException or IOException
            // in this method


            File file = new File(filename);
            Scanner input = new Scanner(file);


            String data;
            int skip = 0;
            int i = 0;
            while (input.hasNext()) {
                if (skip == 0) {
                    data = input.nextLine();
                    skip = 1;
                } else {
                    data = input.nextLine();
                    String[] list = data.split(",");

                    String listTitle = list[9].replaceAll("\"", "");
                    String listAuthor = list[7].replaceAll("\"", "");

                    Book addingBook = new Book(listTitle, listAuthor, Integer.parseInt((list[8]).substring(0, 4)), Double.parseDouble(list[12]));

                    books.add(addingBook);
                    i++;
                }
            }


        } catch (FileNotFoundException ime) {
            System.out.println("File not found.");
        }
    }


    /**
     * Returns a String containing books that are available for checkout
     *
     * @return string with books that are not checked out
     */
    public String getAvailableBooks() {
        // FILL IN CODE

        ArrayList<Book> availableBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isCheckedOut() == false) {
                availableBooks.add(books.get(i));
            }
        }

        String giantString = "";
        for (int j = 0; j < availableBooks.size(); j++) {
            giantString += availableBooks.get(j).toString() + System.lineSeparator();
        }


        return giantString; // remember to change it
    }

    /**
     * Returns a string that contains information about all books
     * from the catalog; one book per line in the same format as in
     * toString method in class Book.
     * Important: instead of adding newline character using
     * "\n", add System.lineSeparator() - it will return the system-dependent line separator
     *
     * @return string representation of the library catalog
     */
    public String toString() {
        // FILL IN CODE

        String allBooksString = "";
        for (int j = 0; j < books.size(); j++) {
            allBooksString += books.get(j) + System.lineSeparator();
        }

        return allBooksString; // remember to change it
    }

}
