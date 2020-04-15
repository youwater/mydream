package mydream.service.saying;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mydream.mapper.saying.SayingMapper;
import mydream.vo.saying.SayingVO;
import mydream.vo.song.SongVO;

@Service
public class SayingService {

	@Autowired
	SayingMapper sayingMapper;
	
	public void sayingwrite(SayingVO sayingVO) {
		sayingVO.setEngcontent(sayingVO.getEngcontent().replace("'", "+"));
		sayingVO.setEngname(sayingVO.getEngname().replace("'", "+"));
		sayingMapper.sayingwrite(sayingVO);
	}

	public Object selectListSayinfo() {
		
		List<SayingVO> sayingVO =  sayingMapper.selectListSayinfo();
		
		for(int i=0;i<sayingVO.size();i++) {
			sayingVO.get(i).setEngcontent(sayingVO.get(i).getEngcontent().replace("+", "'"));
			sayingVO.get(i).setEngcontent(sayingVO.get(i).getEngcontent().replace("+", "'"));
		}
		return sayingVO;
	}

}
