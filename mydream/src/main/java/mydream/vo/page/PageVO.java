package mydream.vo.page;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageVO {

	/** 현재페이지 */
	private int pageIndex;
	/** 페이지사이즈 */
	private int pageSize = 30; // 한페이지에 나오는 게시물 개수
	String type;

}
