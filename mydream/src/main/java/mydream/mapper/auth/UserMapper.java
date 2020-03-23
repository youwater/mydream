package mydream.mapper.auth;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import mydream.vo.auth.UserVO;

@Mapper
public interface UserMapper {

	Boolean existsByUserId(String id);

	void insertUser(UserVO vo);

	UserVO loginUserId(String id);
}
