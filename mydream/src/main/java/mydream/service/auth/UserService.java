package mydream.service.auth;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mydream.mapper.auth.UserMapper;
import mydream.vo.auth.UserVO;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public boolean existsByUserId(String id) {
		 return userMapper.existsByUserId(id);
	}

	public void insertUser(UserVO vo) {
		log.info("패스워드 암호와 및 계정 등록");
		String hashPWD = BCrypt.hashpw(vo.getPassword(), BCrypt.gensalt());
		vo.setPassword(hashPWD);
		userMapper.insertUser(vo);
	}

	public UserVO loginUserId(String id) {
		return userMapper.loginUserId(id);
	}
}