package br.com.devdojo.projetoinicial.persistence.fileservice;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class FileXMLService {

    private Document doc;

    public FileXMLService(String filename) {
        InputStream xml = getClass().getClassLoader().getResourceAsStream(filename);
        try {
            configure(xml);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void configure(InputStream xml) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        this.doc = documentBuilder.parse(xml);
    }

    public String findValue(String key) {
        Element element = doc.getDocumentElement();
        NodeList nodeList = doc.getElementsByTagName("query");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                String attr = e.getAttribute("id");
                if (attr.equals(key)) {
                    return e.getTextContent();
                }
            }
        }
        return null;
    }
}