package mydream.controller.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mydream.service.word.WordService;

@Controller
public class WordController {

	@Autowired
	WordService wordService;
	
	@RequestMapping("/word/toeic")
	public ModelAndView toeic(ModelAndView m,Model model,Device device) throws Exception {
	
	if(device.isMobile()) {
		System.out.println("모바일입니다");	
		 m.setViewName("mydream/mobile/word/word");
	}else {
		System.out.println("pc입니다");
		 m.setViewName("mydream/pc/word/word");
	}
	
	 m.addObject("word",wordService.selectListWordToeic());
	 
	 
	return m;
	}	
}
