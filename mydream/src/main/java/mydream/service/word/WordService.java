package mydream.service.word;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mydream.mapper.word.WordMapper;
import mydream.vo.page.PageVO;

@Service
public class WordService {

	@Autowired
	WordMapper wordMapper;
	
	public List selectListWordToeic(PageVO page) {
		return wordMapper.selectListWordToeic(page);
	}

	public int selectCountWordToeic() {
		return wordMapper.selectCountWordToeic();
	}

	public int selectCountWordTople() {
		return wordMapper.selectCountWordTople();
	}

	public List selectListWordTople(PageVO page) {
		return wordMapper.selectListWordTople(page);
	}

}
