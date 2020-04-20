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
	
	public List selectListWord(PageVO page) {
		return wordMapper.selectListWord(page);
	}

	public int selectCountWord(PageVO page) {
		return wordMapper.selectCountWord(page);
	}
}
