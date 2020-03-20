package mydream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import mydream.service.MydreamService;

@Slf4j
@Controller
public class WebController {

	   @Autowired
	   MydreamService mydreamService;
	   
	@RequestMapping("/")
		public String index(Model model,Device device) throws Exception {
		
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
		}else {
			System.out.println("pc입니다");
		}

		return "index";
	}
}
