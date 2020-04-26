package mydream.controller.engtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mydream.service.engtest.EngtestService;
import mydream.vo.engtest.EngtestVO;

@Controller
public class EngtestController {

	@Autowired
	EngtestService emgntestService;
	
	@RequestMapping("/engtest/engtest")
	@ResponseBody
	public ModelAndView engtest(ModelAndView m ,Device device) throws Exception {
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("mydream/mobile/engtest/toeic5");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("mydream/pc/engtest/toeic5");
		}
		
		List<EngtestVO> eng = emgntestService.selectToeicPart5();
		m.addObject("test",eng);
		return m;
	}
	
	@RequestMapping("/engtest/checkengtest")
	@ResponseBody
	public ModelAndView checkengtest(ModelAndView m ,Device device,EngtestVO engtestVO) throws Exception {
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("mydream/mobile/engtest/toeic5answer");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("mydream/pc/engtest/toeic5answer");
		}
		List<String> answer = new ArrayList<String>();
		answer.add(engtestVO.getAnswer1());
		answer.add(engtestVO.getAnswer2());
		answer.add(engtestVO.getAnswer3());
		
		List<EngtestVO> eng2 = emgntestService.selectToeicPart5Answer(engtestVO);
		m.addObject("test",eng2);
		m.addObject("answer",answer);
		return m;
	}
	
	@RequestMapping("/engtest/toeic5list")
	@ResponseBody
	public ModelAndView toeic5list(ModelAndView m ,Device device,EngtestVO engtestVO) throws Exception {
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("mydream/mobile/engtest/toeic5list");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("mydream/pc/engtest/toeic5list");
		}
		
		int count = emgntestService.selectEngtestCount();
		
		
	
		m.addObject("list",ab);
		return m;
	}
}
