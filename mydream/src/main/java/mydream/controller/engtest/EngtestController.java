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
	
	@RequestMapping("/engtest/toeic5")
	@ResponseBody
	public ModelAndView engtest(ModelAndView m ,Device device, EngtestVO engtestVO) throws Exception {
		if(device.isMobile()) {
			 m.setViewName("mydream/mobile/engtest/toeic5");
		}else {
			 m.setViewName("mydream/pc/engtest/toeic5");
		}
		
		m.addObject("day",engtestVO.getDay());
		List<EngtestVO> eng = emgntestService.selectToeicPart5(engtestVO);
		m.addObject("test",eng);
		
		return m;
	}
	
	@RequestMapping("/engtest/checkengtest")
	@ResponseBody
	public ModelAndView checkengtest(ModelAndView m ,Device device,EngtestVO engtestVO) throws Exception {
		if(device.isMobile()) {
			 m.setViewName("mydream/mobile/engtest/toeic5answer");
		}else {
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
			 m.setViewName("mydream/mobile/engtest/toeic5list");
		}else {
			 m.setViewName("mydream/pc/engtest/toeic5list");
		}
		
		int count = emgntestService.selectEngtestCount();
		ArrayList<HashMap<String ,Object>> aaa = new ArrayList<HashMap<String,Object>>();
		
		for(int i=1; i<=count/3; i++) {
			HashMap<String, Object> aa = new HashMap<String, Object>();
			aa.put("num", i);
			aa.put("type", "part5");
			aa.put("day", i+" 일차");
			aa.put("title", i+"일차 토익 RC Part5 문제 풀기 ");
			aaa.add(aa);
		}
		m.addObject("aaa",aaa);
		
		return m;
	}
	
	@RequestMapping("/engtest/toeic5write")
	@ResponseBody
	public ModelAndView toeic5write(ModelAndView m ,Device device,EngtestVO engtestVO) throws Exception {
		if(device.isMobile()) {
			 m.setViewName("mydream/mobile/engtest/toeic5write");
		}else {
			 m.setViewName("mydream/pc/engtest/toeic5write");
		}
		
	
		return m;
	}
	
	@RequestMapping("/engtest/toeic5insert")
	@ResponseBody
	public ModelAndView toeic5insert(ModelAndView m ,Device device,EngtestVO engtestVO) throws Exception {
		
		if(device.isMobile()) {
			 m.setViewName("mydream/mobile/engtest/toeic5write");
		}else {
			 m.setViewName("mydream/pc/engtest/toeic5write");
		}
		
		emgntestService.toeic5insert(engtestVO);
		emgntestService.toeic5answerinsert(engtestVO);
	
		
		return m;
	}
	
	
}
