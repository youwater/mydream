package mydream.controller.word;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mydream.service.word.WordService;
import mydream.vo.page.PageVO;

@Controller
public class WordController {

	@Autowired
	WordService wordService;

	@RequestMapping("/word/word")
	public ModelAndView toeic(ModelAndView m, Model model, Device device, PageVO page) throws Exception {

		if (page.getPageIndex() == 0) {
			page.setPageIndex(1);
		}
		if (device.isMobile()) {
			System.out.println("모바일입니다");
			m.setViewName("mydream/mobile/word/word");
		} else {
			System.out.println("pc입니다");
			m.setViewName("mydream/pc/word/word");
		}

		int count = wordService.selectCountWord(page);
		int start = 0;

		if (page.getPageIndex() / 5 == 0) {
			start = page.getPageIndex() / 5 * 5 + 1;
		} else if (page.getPageIndex() % 5 == 0) {
			start = (page.getPageIndex() - 1) / 5 * 5 + 1;
		} else {
			start = page.getPageIndex() / 5 * 5 + 1;
		}
		
		int end = (start + 4 <= count / page.getPageSize()) ? start + 4 : count / page.getPageSize();
		m.addObject("word", wordService.selectListWord(page));
		m.addObject("start", start);
		m.addObject("end", end);
		m.addObject("count", count / page.getPageSize());
		m.addObject("type", page.getType());

		return m;
	}
	
	@RequestMapping("/word/wordtest")
	public ModelAndView wordtest(ModelAndView m, Model model, Device device, PageVO page) throws Exception {
		if (device.isMobile()) {
			System.out.println("모바일입니다");
			m.setViewName("mydream/mobile/word/wordtest");
		} else {
			System.out.println("pc입니다");
			m.setViewName("mydream/pc/word/wordtest");
		}
		double dValue = Math.random();
		int iValue1 = (int)(dValue * 5);
		List a =  wordService.selectwordtest(page);
		
		m.addObject("wordeng", a.get(iValue1));
		m.addObject("word", a);
		
		
		return m;
	}
	
	@RequestMapping("/word/wordmobile")
	public ModelAndView wordmobile(ModelAndView m, Model model, Device device, PageVO page) throws Exception {
			m.setViewName("mydream/mobile/word/wordmobile");
			m.addObject("word",wordService.selectListIndexWord());
		return m;
	}
	
	@RequestMapping("/word/wordtestmobile")
	public ModelAndView wordtestmobile(ModelAndView m, Model model, Device device, PageVO page) throws Exception {
			m.setViewName("mydream/mobile/word/wordtestmobile");
			m.addObject("word",wordService.selectListIndexWord());
		return m;
	}
}
