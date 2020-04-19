package mydream.service.word;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mydream.mapper.word.WordMapper;

@Service
public class WordService {

	@Autowired
	WordMapper wordMapper;
	
	public List selectListWordToeic() {
		
		return wordMapper.selectListWordToeic();
	}

}
