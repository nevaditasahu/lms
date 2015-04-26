package kr.ac.mju;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@Autowired
	private DAO dao;
		
	@RequestMapping(value = "/GiveGradeToAStudent", method = RequestMethod.POST)
	public ModelAndView giveGradeToAStudent(@RequestParam("studentID") String studentID, @RequestParam("grade") String grade) {
		logger.info("GiveGradeToAStudent");
		boolean result = dao.insertGrade(studentID,grade);
		ModelAndView mv = new ModelAndView();
		if(result){
			mv.addObject("successMessage", "Succed To Write Grade");
		}else{
			mv.addObject("failedMessage", "Failed To Write Grade");
		}
		return mv;
	}
	
}
