package mydream.controller.song;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import mydream.service.song.SongService;
import mydream.vo.song.SongVO;

@Slf4j
@Controller
public class SongController  {

	@Autowired
	SongService songService;
	
	
	@RequestMapping("/song/read")
	@ResponseBody
	public ModelAndView read(ModelAndView m ,Device device,SongVO vo) throws Exception {
		System.out.println(vo.getSongname());
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("mydream/mobile/song/songread");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("mydream/pc/song/songread");
		}
		 m.addObject("song",songService.selectSongInfo(vo.getSongname()));
		 m.addObject("word",songService.selectSongWord(vo.getSongname()));
		 
		return m;
	}
	
	@RequestMapping("/song/write")
	public ModelAndView write(ModelAndView m ,Device device) throws Exception {
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("mydream/mobile/song/songwrite");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("mydream/pc/song/songwrite");
		}
		return m;
	}
	
	@Transactional
	@RequestMapping("/song/songwrite")
	public ModelAndView  songwrite(ModelAndView m ,Device device ,SongVO songvo ,HttpServletRequest request) throws Exception {
		
		
		try {
			songService.insertSong(songvo);
			songService.insertSongword(request,songvo.getSongname());	
		}catch (Exception e) {
			log.error("노래 등록시 에러 발생={}",e);
		}
		
		if(device.isMobile()) {
			System.out.println("모바일입니다");	
			 m.setViewName("mydream/mobile/song/songwrite");
		}else {
			System.out.println("pc입니다");
			 m.setViewName("mydream/pc/song/songwrite");
		}
		return m;
	}
}
