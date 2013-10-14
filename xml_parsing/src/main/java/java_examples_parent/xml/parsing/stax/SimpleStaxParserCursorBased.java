package java_examples_parent.xml.parsing.stax;

import java_examples_parent.xml.parsing.LibraryParser;
import java_examples_parent.xml.parsing.pojos.Book;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class SimpleStaxParserCursorBased implements LibraryParser{

    XMLInputFactory xmlInputFactory;

    public SimpleStaxParserCursorBased() {
        this.xmlInputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public List<Book> extractAllBooks(File exampleFile) throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
        FileInputStream fileInputStream = new FileInputStream(exampleFile);
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(exampleFile.getName(), fileInputStream);
        return null;
    }
}
