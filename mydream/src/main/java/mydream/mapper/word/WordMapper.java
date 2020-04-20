package mydream.mapper.word;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mydream.vo.page.PageVO;

@Mapper
public interface WordMapper {

	List selectListWordToeic(PageVO page);

	int selectCountWordToeic();

	int selectCountWordTople();

	List selectListWordTople(PageVO page);

}
