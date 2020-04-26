package mydream.mapper.engtest;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mydream.vo.engtest.EngtestVO;

@Mapper
public interface EngtestMapper {


	List<EngtestVO> selectToeicPart5();

	List<EngtestVO> selectToeicPart5Answer(EngtestVO engtestVO);

	int selectEngtestCount();
}
