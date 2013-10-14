package java_examples_parent.xml.parsing;

import java_examples_parent.xml.parsing.documentbuilder.DocumentBuilderLibraryParser;
import java_examples_parent.xml.parsing.pojos.Book;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractLibraryTest {
    protected File exampleFile;

    @Before
    public void setUp() throws Exception {
        //Load test file from the class path
        URL url = this.getClass().getClassLoader().getResource("library.xml");
        exampleFile = new File(url.getFile());
        assertNotNull(exampleFile);

    }

    public abstract List<Book> parseBooks(File file) throws Exception;

    @Test
    public void testAllBooksReturned() throws Exception {
        List<Book> books = new DocumentBuilderLibraryParser().extractAllBooks(exampleFile);
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Test
    public void testContentOfFirstBook() throws ParserConfigurationException, SAXException, IOException {
        List<Book> books = new DocumentBuilderLibraryParser().extractAllBooks(exampleFile);
        Book firstBook = books.get(0);
        assertNotNull(firstBook);
        assertNotNull(firstBook.getAuthor());
        assertEquals("Arnie", firstBook.getAuthor());
        assertNotNull(firstBook.getTitle());
        assertEquals("History Book", firstBook.getTitle());
    }
}
