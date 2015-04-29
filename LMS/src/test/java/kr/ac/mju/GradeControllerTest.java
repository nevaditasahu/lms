package kr.ac.mju;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.aspectj.lang.annotation.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author leegaeul
 * This is the test case that tests 'GradeController' class 
 * In order to test controllers, we should write 3 annotations.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:ApplicationContext.xml"})
@WebAppConfiguration
public class GradeControllerTest {
	private GradeController gradeController;
	private DAO dao;
	private Student student;
	String[] gradeList = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
	
	@Before
	public void setUp(){
		dao = new DAO();
		gradeController = new GradeController(dao);
		student = new Student();
		student.setID("82150009");
		student.setName("kim chul soo");
	}
	@After(value = "")
	public void tearDown(){
		dao = null;
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
