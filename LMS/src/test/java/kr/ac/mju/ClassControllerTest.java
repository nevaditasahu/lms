package kr.ac.mju;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class ClassControllerTest {
	
	private ClassController classController;
	private Course course;
	String[] classList = {"l1","l2","l3","l4","l5","l6","l7","l8"};
	
	
	@Test
	public void testCreateClassForCourse() {
		String courseID = course.getID();
		String lecture = classList[3];
		
		ModelAndView mv = classController.createClassForCourse(courseID, lecture);
		assertNotNull(mv);
		assertNotNull(mv.getModel().get("success message"));
		assertNotNull(mv.getModel().get("failed message"));
				
		
	}

}
