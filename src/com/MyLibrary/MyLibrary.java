package com.MyLibrary;

import java.util.ArrayList;

public class MyLibrary {
    private ArrayList<MyBook> booksList;

    public MyLibrary() {
        booksList = new ArrayList<>();
    }

    public MyLibrary(ArrayList<MyBook> booksList) {
        this.booksList = booksList;
    }

    public ArrayList<MyBook> getBooksList() {
        return booksList;
    }

    public void addBook(MyBook book) {
        this.booksList.add(book);
    }

    public void returnBook(MyBook bk){
        bk.getId();
    }

    /**
     * Return List of available books
     * @param search
     * @return
     */
    public ArrayList<MyBook> searchByString(String search) {
        ArrayList<MyBook> foundBooks = new ArrayList<>();
        for (MyBook b : this.booksList) {
            if (b.getName().contains(search) || b.getAuthor().contains(search)) {
                if (b.isAvailable()) {
                    foundBooks.add(b);
                }
            }
        }
        return foundBooks;
    }
    /**
     * Return List of available books
     * @param search
     * @return
     */
    public ArrayList<MyBook> searchByYear(int search) {
        ArrayList<MyBook> foundBooks = new ArrayList<>();
        for (MyBook b : this.booksList) {
            if (b.getYear() == search) {
                if (b.isAvailable()) {
                    foundBooks.add(b);
                }
            }
        }
        return foundBooks;
    }

    public MyBook searchById(int bookId) {
        for (MyBook b : this.booksList) {
            if (b.getId() == bookId) {
                return b;
            }
        }
        return null;
    }

    public ArrayList<MyBook> availableBooks() {
        ArrayList<MyBook> availableBooks = new ArrayList<>();
        for (MyBook b : this.booksList) {
            if (b.isAvailable()) {
                availableBooks.add(b);
            }
        }
        return availableBooks;
    }

    public ArrayList<MyBook> borrowedBooks() {
        ArrayList<MyBook> borrowedBooks = new ArrayList<>();
        for (MyBook b : this.booksList) {
            if (!b.isAvailable()) {
                borrowedBooks.add(b);
            }
        }
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "{" +
                booksList +
                '}';
    }
}
