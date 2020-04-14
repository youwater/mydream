package mydream.controller.saying;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import mydream.service.saying.SayingService;
import mydream.vo.saying.SayingVO;
import mydream.vo.song.SongVO;

@Slf4j
@Controller
public class SayingController {
	
	@Autowired
	SayingService sayingService;
	
	@RequestMapping("/saying/write")
	@ResponseBody
	public ModelAndView write(ModelAndView m ,Device device,SongVO vo) throws Exception {
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("mydream/mobile/saying/sayingwrite");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("mydream/pc/saying/sayingwrite");
		}
		return m;
	}
	
	@Transactional
	@RequestMapping("/saying/sayingwrite")
	public ModelAndView  sayingwrite(ModelAndView m ,Device device ,SayingVO sayingVO ,HttpServletRequest request) throws Exception {
		try {
			sayingService.sayingwrite(sayingVO);
		}catch (Exception e) {
			log.error("명언 등록시 에러 발생={}",e);
		}
		
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("redirect:/");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("redirect:/");
		}
		return m;
	}
	
	@RequestMapping("/saying/sayinglist")
	public ModelAndView  sayinglist(ModelAndView m ,Device device ,SongVO songvo ,HttpServletRequest request) throws Exception {
		
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("mydream/mobile/saying/sayinglist");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("mydream/pc/saying/sayinglist");
		}
		
		 m.addObject("saying",sayingService.selectListSayinfo());
		return m;
	}
	
}
