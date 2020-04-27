package mydream.mapper.engtest;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mydream.vo.engtest.EngtestVO;

@Mapper
public interface EngtestMapper {


	List<EngtestVO> selectToeicPart5(EngtestVO engtestVO);

	List<EngtestVO> selectToeicPart5Answer(EngtestVO engtestVO);

	int selectEngtestCount();

	void toeic5insert(EngtestVO engtestVO);

	void toeic5answerinsert(EngtestVO engtestVO);
}
