package mydream.service.engtest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mydream.mapper.engtest.EngtestMapper;
import mydream.vo.engtest.EngtestVO;

@Service
public class EngtestService {

	@Autowired
	EngtestMapper engtestMapper;
	

	public List<EngtestVO> selectToeicPart5() {
		List<EngtestVO>  engtestVO =engtestMapper.selectToeicPart5();
		return engtestVO;
	}


	public List<EngtestVO> selectToeicPart5Answer(EngtestVO engtestVO) {
		List<EngtestVO>  engtestVO2 =engtestMapper.selectToeicPart5Answer(engtestVO);
		return engtestVO2;
	}


	public int selectEngtestCount() {
		// TODO Auto-generated method stub
		return engtestMapper.selectEngtestCount();
	}

}
