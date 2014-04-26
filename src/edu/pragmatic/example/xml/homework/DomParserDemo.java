package edu.pragmatic.example.xml.homework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		Path pathStudents = Paths.get("resourses/xml/students.xml");
		if (pathStudents == null) return;
		
		File studentsXML = pathStudents.toFile();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document students = documentBuilder.parse(studentsXML);

		NodeList teacherElements = students.getElementsByTagName("teacher");
		for (int i = 0; i < teacherElements.getLength(); i++) {
			Node teacher = teacherElements.item(i);
			NamedNodeMap attributes = teacher.getAttributes();
			String name = attributes.getNamedItem("name").getNodeValue();
			String teaches = attributes.getNamedItem("teaches").getNodeValue();
			System.out.println(name + " teaches " + teaches);
		}

		NodeList studentItems = students.getElementsByTagName("student");
		for (int j = 0; j < studentItems.getLength(); j++) {
			Node student = studentItems.item(j);
			NamedNodeMap attributes = student.getAttributes();
			String name = attributes.getNamedItem("name").getNodeValue();
			String age = attributes.getNamedItem("age").getNodeValue();
			String group = attributes.getNamedItem("group").getNodeValue();
			String sex = attributes.getNamedItem("sex").getNodeValue();
			String mark = attributes.getNamedItem("mark").getNodeValue();
			System.out.printf("%s[%s, %s] from %s with %s\n", name, age, sex, group, mark);
		}

	}
}