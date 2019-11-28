package com.MyLibrary;

public class MyBook {
    private static int bookCount = 0;
    private int id;
    private String name;
    private String Author;
    private int year;
    private int Edition;
    private boolean Status = true;

    /**
     * @param name
     * @param author
     * @param year
     * @param edition
     */
    public MyBook(String name, String author, int year, int edition) {
        this.bookCount++;
        this.id = this.bookCount;
        this.name = name;
        this.Author = author;
        this.year = year;
        this.Edition = edition;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return Author;
    }

    public int getYear() {
        return year;
    }

    public int getEdition() {
        return Edition;
    }

    public boolean isAvailable() {
        return Status;
    }

    public Boolean loanBook() {
        if (this.Status) {
            this.Status = false;
            return true;
        }
        return false;
    }

    public Boolean returnBook() {
        if (!this.Status) {
            this.Status = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{ " +
                " ID='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Author='" + Author + '\'' +
                ", year=" + year +
                ", Edition=" + Edition +
                ", Status=" + Status + "}\n";
    }
}
