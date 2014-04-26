package edu.pragmatic.example.xml.homework;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SaxParserDemo {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		xmlReader.setContentHandler(new StudentsContentFile());

		xmlReader.parse(new InputSource(new FileReader(new File(
				"resourses/xml/students.xml"))));

	}

}