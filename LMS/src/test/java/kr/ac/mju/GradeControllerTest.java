package kr.ac.mju;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:ApplicationContext.xml"})
@WebAppConfiguration
public class GradeControllerTest {
	@Autowired
	private GradeController gradeController;
	private Student student;
	String[] gradeList = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
	
	@Before
	public void setUp(){
		student = new Student();
		student.setID("82150009");
		student.setName("kim chul soo");
	}
	@After(value = "")
	public void tearDown(){
		gradeController = null;
		student = null;
	}
	@Test 
	public void testGiveGradeToAStudent(){
		String studentID = student.getID();
		String grade = gradeList[3];
		ModelAndView mv = gradeController.giveGradeToAStudent(studentID, grade);
		assertNotNull(mv);
		assertNotNull(mv.getModel().get("successMessage"));
		assertNull(mv.getModel().get("failedMessage"));
		
	}

}
