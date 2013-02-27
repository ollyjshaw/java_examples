package java_examples_parent;


import org.junit.Before;
import org.junit.Test;

import java.io.File;
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
    public void testExtractAllBooks() throws Exception {
      List<Book> books = new SimpleLibraryParser().extractAllBooks(exampleFile);
      assertNotNull(books);
      assertEquals(3, books.size());
    }
}
