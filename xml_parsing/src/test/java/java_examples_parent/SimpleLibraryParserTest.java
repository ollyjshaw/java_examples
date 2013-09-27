package java_examples_parent;


import java_examples_parent.xml.parsing.Book;
import java_examples_parent.xml.parsing.SimpleLibraryParser;
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

/**
 * Test the parsing code
 */
public class SimpleLibraryParserTest {
    private File exampleFile;

    @Before
    public void setUp() throws Exception {
        //Load test file from the class path
        URL url = this.getClass().getClassLoader().getResource("library.xml");
        exampleFile = new File(url.getFile());
        assertNotNull(exampleFile);
    }

    @Test
    public void testAllBooksReturned() throws Exception {
        List<Book> books = new SimpleLibraryParser().extractAllBooks(exampleFile);
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Test
    public void testContentOfFirstBook() throws ParserConfigurationException, SAXException, IOException {
        List<Book> books = new SimpleLibraryParser().extractAllBooks(exampleFile);
        Book firstBook = books.get(0);
        assertNotNull(firstBook);
        assertNotNull(firstBook.getAuthor());
        assertEquals("Arnie", firstBook.getAuthor());
        assertNotNull(firstBook.getTitle());
        assertEquals("History Book", firstBook.getTitle());
    }

}
