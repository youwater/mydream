package mydream.vo.auth;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {

	String userid;
	String password;
	String password2;
	int lifeNumber;
	int age;
	String gender;
	Date createDate;
}
