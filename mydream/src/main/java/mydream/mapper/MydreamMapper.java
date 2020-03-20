package mydream.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mydream.vo.MydreamVO;

@Mapper
public interface MydreamMapper {
	
	public List<MydreamVO> mydream();

}
