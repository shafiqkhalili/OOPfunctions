package com.MyLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        MyLibrary library = new MyLibrary();

        MyBook book1 = new MyBook("Book1", "Author1", 2001, 1000);
        MyBook book2 = new MyBook("Book2", "Author2", 2002, 2000);
        MyBook book3 = new MyBook("Book3", "Author3", 2003, 3000);
        MyBook book4 = new MyBook("Book4", "Author4", 2004, 4000);
        MyBook book5 = new MyBook("Book5", "Author5", 2005, 5000);
        book3.loanBook();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        int selectedOption = 0;
        MyBook createdBook;
        System.out.println("Welcome to MyLibrary");
        while (selectedOption != 5) {
            System.out.println("Select a number/option to continue:");
            System.out.println("1. Add a book to the library");
            System.out.println("2. Search a book");
            System.out.println("3. List all available books");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            selectedOption = sc.nextInt();
            switch (selectedOption) {
                case 1:
                    library.addBook(addBookToLibrary());
                    break;
                case 2:
                    searchBook(library);
                    break;
                case 3:
                    System.out.println("List of all available books\n" + library.availableBooks());
                    break;
                case 4:
                    returnBook(library);
                    break;
                case 5:
                    selectedOption = 5;
                    break;
                default:
                    System.out.println("Please select a valid option!");
            }
        }
        System.out.println("Program closed !");
        sc.close();

    }

    private static MyBook addBookToLibrary() throws IOException {
        Scanner sc = new Scanner(System.in);

        int yearNow = Calendar.getInstance().get(Calendar.YEAR);
        int year = yearNow;

        System.out.println("Write Book's name:");
        String name = sc.nextLine();
        System.out.println("Write Book's author:");
        String author = sc.nextLine();
        System.out.println("Write Book's publishing year: Default = " + yearNow);
        year = sc.nextInt();
        if (!(year > 0)) {
            year = yearNow;
        }
        System.out.println("Write Book's edition:");
        int edition = sc.nextInt();

        MyBook book = new MyBook(name, author, year, edition);
        System.out.println("Created: " + book);
        return book;
    }

    private static void searchBook(MyLibrary library) {
        int selectedOption = 0;
        ArrayList<MyBook> bookList;
        String input = "";
        Scanner sc = new Scanner(System.in);
        while (selectedOption != 2) {
            System.out.println("Select the search method:");
            System.out.println("1. Search by book name/author");
            System.out.println("2. Exit");
            selectedOption = sc.nextInt();
            switch (selectedOption) {
                case 1:
                    selectedOption = 0;
                    System.out.println("Write name/author of the book to search!");
                    System.out.println("Or type Exit to return");
                    input = sc.nextLine();
                    bookList = library.searchByString(input);
                    if (bookList.size() <= 0) {
                        System.out.println("Search result is empty");
                    } else {
                        System.out.println("Search result: \n" + bookList);
                        System.out.println("Write the id of the book to borrow");
                        System.out.println("Or type (0) to cancel the process");
                        selectedOption = sc.nextInt();
                        if (selectedOption == 0) {
                            System.out.println("Returning to previous menu!");
                        } else if (selectedOption > 0) {
                            borrowBook(library, selectedOption);
                        }
                        else{
                            selectedOption = 2;
                            break;
                        }
                    }
                    break;
                case 2:
                    selectedOption = 2;
                    System.out.println("Returning to main menu!");
                    break;
                default:
                    System.out.println("Please select a valid option!");
                    break;
            }
        }
    }

    private static boolean borrowBook(MyLibrary library, int bookId) {
        List<MyBook> books = new ArrayList<>();
        boolean found = false;
        for (MyBook f : library.availableBooks()) {
            if (f.getId() == bookId) {
                f.loanBook();
                System.out.println("You borrowed successfully: " + f.getName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with ID " + bookId + " not found!");
        }
        return found;
    }

    private static boolean returnBook(MyLibrary library) {
        Scanner snr = new Scanner(System.in);
        System.out.println(library.borrowedBooks());
        System.out.println("Select a book by ID to return:");
        int bookId = snr.nextInt();
        boolean found = false;
        for (MyBook f : library.borrowedBooks()) {
            if (f.getId() == bookId) {
                f.returnBook();
                System.out.println("You returned successfully: " + f.getName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with ID " + bookId + " not found!");
        }
        return found;
    }
}