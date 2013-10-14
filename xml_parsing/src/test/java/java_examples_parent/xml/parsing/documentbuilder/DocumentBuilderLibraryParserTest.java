package java_examples_parent.xml.parsing.documentbuilder;


import java_examples_parent.xml.parsing.AbstractLibraryTest;
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

/**
 * Test the parsing code
 */
public class DocumentBuilderLibraryParserTest extends AbstractLibraryTest{

    @Override
    public List<Book> parseBooks(File file) throws Exception{
        return new DocumentBuilderLibraryParser().extractAllBooks(file);
    }
}
