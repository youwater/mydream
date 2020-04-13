package mydream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import mydream.service.MydreamService;
import mydream.service.song.SongService;
import mydream.vo.song.SongVO;

@Slf4j
@Controller
public class WebController {

	   @Autowired
	   MydreamService mydreamService;
	   
	   @Autowired
	   SongService songService;
	   
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
		return m;
	}
	
	
}
