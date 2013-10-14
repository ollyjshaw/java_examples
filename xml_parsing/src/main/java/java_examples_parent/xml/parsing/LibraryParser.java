package java_examples_parent.xml.parsing;

import java_examples_parent.xml.parsing.pojos.Book;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface LibraryParser {
    public List<Book> extractAllBooks(File exampleFile) throws IOException, SAXException, ParserConfigurationException, XMLStreamException;
}
