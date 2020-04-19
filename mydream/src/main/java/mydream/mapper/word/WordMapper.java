package mydream.mapper.word;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WordMapper {

	List selectListWordToeic();

}
