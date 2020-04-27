package mydream.service.engtest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mydream.mapper.engtest.EngtestMapper;
import mydream.vo.engtest.EngtestVO;

@Service
public class EngtestService {

	@Autowired
	EngtestMapper engtestMapper;
	

	public List<EngtestVO> selectToeicPart5(EngtestVO engtestVO) {
		List<EngtestVO>  engtestVO3 =engtestMapper.selectToeicPart5(engtestVO);
		return engtestVO3;
	}


	public List<EngtestVO> selectToeicPart5Answer(EngtestVO engtestVO) {
		List<EngtestVO>  engtestVO2 =engtestMapper.selectToeicPart5Answer(engtestVO);
		return engtestVO2;
	}


	public int selectEngtestCount() {
		// TODO Auto-generated method stub
		return engtestMapper.selectEngtestCount();
	}

	@Transactional
	public void toeic5insert(EngtestVO engtestVO) {
		String [] spanswer = engtestVO.getAnswerview().split("\\n");
		engtestVO.setView1(spanswer[0]);
		engtestVO.setView2(spanswer[1]);
		engtestVO.setView3(spanswer[2]);
		engtestVO.setView4(spanswer[3]);
		engtestMapper.toeic5insert(engtestVO);
		
	}

	@Transactional
	public void toeic5answerinsert(EngtestVO engtestVO) {
		engtestMapper.toeic5answerinsert(engtestVO);
		
	}

}
