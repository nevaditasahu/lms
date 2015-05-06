package kr.ac.mju;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class ClassController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClassController.class);
	
	private DAO dao;
	
	@RequestMapping(value = "/createClassForCourse", method = RequestMethod.POST)
	public ModelAndView createClassForCourse(@RequestParam("courseID") String courseID, @RequestParam("class") String lecture) {
		logger.info("CreateClassForCourse");
		boolean result = dao.insertClass(courseID,lecture);
		
				
		ModelAndView mv = new ModelAndView();
		if(result){
					mv.addObject("success message", "Succed To create class");
		}else{
					mv.addObject("failed message", "failed to create class");
		}
		
		return mv;
		
	}
}
