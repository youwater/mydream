package mydream.controller.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import mydream.service.auth.UserService;
import mydream.vo.auth.UserVO;

@Slf4j
@Controller
public class AuthController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/auth/createuser")
	public String createuser(Model model, Device device) throws Exception {

		if (device.isMobile()) {
			System.out.println("모바일입니다");
		} else {
			System.out.println("pc입니다");
		}

		return "mydream/auth/createuser";
	}
	
	@RequestMapping("/auth/login")
	public String login(Model model, Device device) throws Exception {

		if (device.isMobile()) {
			System.out.println("모바일입니다");
		} else {
			System.out.println("pc입니다");
		}

		return "mydream/auth/login";
	}
	
	@RequestMapping("/auth/createuserJava")
	public String createuserJava(Model model, Device device) throws Exception {

		if (device.isMobile()) {
			System.out.println("모바일입니다");
		} else {
			System.out.println("pc입니다");
		}

		return "mydream/auth/login";
	}
	
	@RequestMapping("/createUser")
    @ResponseBody
	public Map<String, Object> createUser(@RequestBody UserVO vo ,HttpSession session){
		log.info("유저생성 요청이 들어왔습니다. params={}",vo);
		Map<String,Object> result = new HashMap<String, Object>();
		
		String id = vo.getUserid();
		String pwd = vo.getPassword();
		String pwd2 = vo.getPassword2();
		int age = vo.getAge();
		System.out.println(age);
		if(!userService.existsByUserId(vo.getUserid())){
			if(!id.matches("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*") || id.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){
			 	result.put("message", "아이디는 특수문자,한글은 사용하실수 없습니다");
			 	result.put("resultYn", "N");
			 	return result;
			  }else if(!(id.length() > 3 && id.length() < 11)){
				  result.put("message", "아이디는 4자리 이상 10 이하 가능합니다.");
				  result.put("resultYn", "N");
				  return result;
			  }else if(!(pwd.length() >3 && pwd.length() <15)) {
				  result.put("message", "비밀번호는 4자리 이상 14 이하 가능합니다.");
				  result.put("resultYn", "N");
				  return result;
			  }else if(!(pwd.equals(pwd2))) {
				  result.put("message", "비밀번호 확인 해주세요");
				  result.put("resultYn", "N");
				  return result;
			  }
			  else if(age > 120 || age == 0 || age < 0) {
				  result.put("message", "나이를 확인 해주세요");
				  result.put("resultYn", "N");
				  return result;
			  }else {
				  userService.insertUser(vo);
				  session.setAttribute("sessionUser", vo.getUserid());
				  result.put("message", "가입 완료하였습니다");
				  result.put("resultYn", "Y");
				  return result;
			  }
		}else {
			  result.put("message", "아이디가 존재합니다.");
			  result.put("resultYn", "N");
			  return result;
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		log.info("로그아웃 요청");
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/login")
    @ResponseBody
	public Map<String, Object> login(@RequestBody UserVO vo ,HttpSession session) {
		log.info("로그인 요청이 들어왔습니다. params={}",vo);
		Map<String,Object> result = new HashMap<String, Object>();
		
			String id = vo.getUserid();
			String pwd = vo.getPassword();
			UserVO createUser  = userService.loginUserId(id);
			
			if(createUser == null) {
				result.put("message", "로그인 실패하였습니다.");
			 	result.put("resultYn", "N");
			 	return result;
			}
			if(!BCrypt.checkpw(pwd, createUser.getPassword())) {
				result.put("message", "로그인 실패하였습니다.");
			 	result.put("resultYn", "N");
			 	return result;
			}else {
				session.setAttribute("sessionUser", vo.getUserid());
				result.put("message", "로그인 성공.");
			 	result.put("resultYn", "Y");
			 	return result;
			}
	}
}
