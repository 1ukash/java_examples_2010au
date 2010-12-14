package ru.spbstu.telematics.stud.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxXMLReader {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		InputStream is = XMLReader.class.getResourceAsStream("/data.xml");
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(is, new DefaultHandler() {

			@Override
			public void startElement(String uri, String localName,
					String qName, Attributes attributes) throws SAXException {
				super.startElement(uri, localName, qName, attributes);
				System.out.println(qName);
				
			}

			@Override
			public void endElement(String uri, String localName, String qName)
					throws SAXException {
				super.endElement(uri, localName, qName);
				System.out.println("end " +  qName);
			}

			@Override
			public void characters(char[] ch, int start, int length)
					throws SAXException {
				super.characters(ch, start, length);
//				System.out.println("characters" + " " + new String(ch));
			}
			
		});
	}

}
