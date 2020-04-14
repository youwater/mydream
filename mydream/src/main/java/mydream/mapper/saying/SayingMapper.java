package mydream.mapper.saying;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mydream.vo.saying.SayingVO;

@Mapper
public interface SayingMapper {

	void sayingwrite(SayingVO sayingVO);

	List<SayingVO> selectListSayinfo();
	
}
