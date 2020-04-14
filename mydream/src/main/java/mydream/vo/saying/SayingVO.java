package mydream.vo.saying;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SayingVO {

	int num;
	String engname;
	String job;
	String engcontent;
	String korcontent;
	Date regDt;
	int clickcount;
}
