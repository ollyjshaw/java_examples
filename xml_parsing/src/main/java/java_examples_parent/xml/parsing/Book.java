package java_examples_parent.xml.parsing;

/**
 * Simple Book object
 */
public class Book {
    private final String Author;
    private final String Title;

    public Book(String author, String title) {
        Author = author;
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }
}
