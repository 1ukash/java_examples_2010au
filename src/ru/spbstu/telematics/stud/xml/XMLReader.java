package ru.spbstu.telematics.stud.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XMLReader {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		InputStream is = XMLReader.class.getResourceAsStream("/data.xml");
		
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(is);
		
		NodeList children = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node item = children.item(i);
			if (item instanceof Element) {
				Element el = (Element) item;
				if ("font".equals(el.getTagName())) {
					String val = ((Text) el.getFirstChild()).getData().trim();
				}
			}
		}
	}
}
