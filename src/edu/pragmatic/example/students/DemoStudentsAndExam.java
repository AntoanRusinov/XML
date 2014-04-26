package edu.pragmatic.example.students;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXB;

import edu.pragmatic.example.students.HighSchool.Exams.Exam;
import edu.pragmatic.example.students.HighSchool.People.Students.Student;

public class DemoStudentsAndExam {

	public static void main(String[] args) {
		File students = new File("resourses/xml/students.xml");

		HighSchool highSchool = JAXB.unmarshal(students, HighSchool.class);

		ObjectFactory factory = new ObjectFactory();
		Exam exam = factory.createHighSchoolExamsExam();
		exam.discpline = "Math";
		exam.note = "Great Job";
		exam.value="6.00";
		highSchool.exams.exam.add(exam);
		
		List<Student> studetns = highSchool.getPeople().getStudents().student;
		for (Student student : studetns) {
			for ( edu.pragmatic.example.students.HighSchool.People.Students.Student.Exam studentExam :student.exam ){
				if (student.sex.equals("female")){
					studentExam.note = " Old Perv says hi!";
					studentExam.value = "6.00";
				}else {
					studentExam.note = "Read some books man";
					studentExam.value = "5.50";
				}
			}
		}
		
		JAXB.marshal(highSchool, new File("resourses/xml/students_updated.xml"));

		
		
	}

}
