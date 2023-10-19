import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private List<Book> books;

    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                return true; // Book removed successfully
            }
        }
        return false; // Book not found
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)) {
                results.add(book);
            }
        }
        return results;
    }

    public void displayCatalog() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }

    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        catalog.addBook(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling"));
        catalog.addBook(new Book("The white tiger", "Arvind Adiga"));
        catalog.addBook(new Book("its start with us", "Colleen Hoover"));

        System.out.println("Library Catalog:");
        catalog.displayCatalog();

        List<Book> searchResults = catalog.searchBooks("Harry Potter");
        System.out.println("\nSearch results for 'Harry Potter':");
        catalog.displayCatalog();
        if (catalog.removeBook("The white tiger")) {
            System.out.println("\nRemoved 'The white tiger' from the catalog.");
        } else {
            System.out.println("\n'The white tiger' not found in the catalog.");
        }

        System.out.println("\nLibrary Catalog:");
        catalog.displayCatalog();
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}