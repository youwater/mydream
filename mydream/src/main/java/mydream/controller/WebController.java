package mydream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import mydream.service.MydreamService;
import mydream.service.saying.SayingService;
import mydream.service.song.SongService;

@Slf4j
@Controller
public class WebController {

	   @Autowired
	   MydreamService mydreamService;
	   
	   @Autowired
	   SongService songService;
	   
	   @Autowired
	   SayingService sayingService;
	   
	   
	@RequestMapping("/")
		public ModelAndView index(ModelAndView m,Model model,Device device) throws Exception {
		
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("mydream/mobile/index");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("mydream/pc/index");
		}
		 m.addObject("song",songService.selectListSongInfo());
		 m.addObject("word",songService.selectListSongWord());
		 m.addObject("saying",sayingService.selectListSayinfo());
		return m;
	}
	
	@RequestMapping("/basic/basic8")
	public ModelAndView basic8(ModelAndView m,Model model,Device device) throws Exception {
	
	if(device.isMobile()) {
		System.out.println("모바일입니다");	
		 m.setViewName("mydream/mobile/basic/basic8");
	}else {
		System.out.println("pc입니다");
		 m.setViewName("mydream/pc/basic/basic8");
	}
	
	return m;
	}
	
	@RequestMapping("/basic/basic5")
	public ModelAndView basic5(ModelAndView m,Model model,Device device) throws Exception {
	
	if(device.isMobile()) {
		System.out.println("모바일입니다");	
		 m.setViewName("mydream/mobile/basic/basic5");
	}else {
		System.out.println("pc입니다");
		 m.setViewName("mydream/pc/basic/basic5");
	}
	
	return m;
	}
	
}
