package java_examples_parent.xml.parsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SimpleLibraryParser {
    public static final String EXAMPLE_NAMESPACE = "http://www.example.com";
    private final DocumentBuilderFactory dbf;

    public SimpleLibraryParser() {
        this.dbf = DocumentBuilderFactory.newInstance();
        this.dbf.setNamespaceAware(true);
    }

    public List<Book> extractAllBooks(File exampleFile) throws IOException, SAXException, ParserConfigurationException {
        Document document = null;
        document = parseXmlFile(exampleFile);
        List<Book> books = extractBooks(document);
        return books;
    }

    private List<Book> extractBooks(Document document) {
        List<Book> books = new LinkedList<Book>();
        Element rootElement = document.getDocumentElement();
        NodeList nodeList = rootElement.getElementsByTagNameNS(EXAMPLE_NAMESPACE, "Book");
        if (nodeList != null && nodeList.getLength() > 0) {
            for (int ii = 0; ii < nodeList.getLength(); ii++) {

                Element element = (Element) nodeList.item(ii);

                Book book = getBook(element);

                books.add(book);
            }
        }
        return books;
    }

    private Book getBook(Element element) {
        String author = getTextValue(element, "Author");
        String title = getTextValue(element, "Title");

        Book book = new Book(author, title);

        return book;
    }

    private String getTextValue(Element element, String tagName) {
        String value = null;
        NodeList nodeList = element.getElementsByTagNameNS(EXAMPLE_NAMESPACE, tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Element el = (Element) nodeList.item(0);
            value = el.getFirstChild().getNodeValue();
        }

        value = value.trim();

        return value;

    }

    private Document parseXmlFile(File exampleFile) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document document = builder.parse(exampleFile);
        return document;
    }
}
