package mydream.controller.word;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mydream.service.word.WordService;
import mydream.vo.page.PageVO;

@Controller
public class WordController {

	@Autowired
	WordService wordService;

	@RequestMapping("/word/toeic")
	public ModelAndView toeic(ModelAndView m, Model model, Device device, PageVO page) throws Exception {

		if (page.getPageIndex() == 0) {
			page.setPageIndex(1);
		}
		if (device.isMobile()) {
			System.out.println("모바일입니다");
			m.setViewName("mydream/mobile/word/toeic");
		} else {
			System.out.println("pc입니다");
			m.setViewName("mydream/pc/word/toeic");
		}

		int count = wordService.selectCountWordToeic();
		int start = 0;

		if (page.getPageIndex() / 5 == 0) {
			start = page.getPageIndex() / 5 * 5 + 1;
		} else if (page.getPageIndex() % 5 == 0) {
			start = (page.getPageIndex() - 1) / 5 * 5 + 1;
		} else {
			start = page.getPageIndex() / 5 * 5 + 1;
		}
		
		int end = (start + 4 <= count / page.getPageSize()) ? start + 4 : count / page.getPageSize();
		m.addObject("word", wordService.selectListWordToeic(page));
		m.addObject("start", start);
		m.addObject("end", end);
		m.addObject("count", count / page.getPageSize());

		return m;
	}
	
	@RequestMapping("/word/tople")
	public ModelAndView tople(ModelAndView m, Model model, Device device, PageVO page) throws Exception {

		if (page.getPageIndex() == 0) {
			page.setPageIndex(1);
		}
		if (device.isMobile()) {
			System.out.println("모바일입니다");
			m.setViewName("mydream/mobile/word/tople");
		} else {
			System.out.println("pc입니다");
			m.setViewName("mydream/pc/word/tople");
		}

		int count = wordService.selectCountWordTople();
		int start = 0;

		if (page.getPageIndex() / 5 == 0) {
			start = page.getPageIndex() / 5 * 5 + 1;
		} else if (page.getPageIndex() % 5 == 0) {
			start = (page.getPageIndex() - 1) / 5 * 5 + 1;
		} else {
			start = page.getPageIndex() / 5 * 5 + 1;
		}
		
		int end = (start + 4 <= count / page.getPageSize()) ? start + 4 : count / page.getPageSize();
		m.addObject("word", wordService.selectListWordTople(page));
		m.addObject("start", start);
		m.addObject("end", end);
		m.addObject("count", count / page.getPageSize());

		return m;
	}
}
