package mydream.vo.word;

import lombok.Getter;
import lombok.Setter;
import mydream.vo.page.PageVO;

@Getter
@Setter
public class WordVO extends PageVO{
	int num;
	String wordtype;
	String englishword;
	String koreaword;
}
