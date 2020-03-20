package mydream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mydream.mapper.MydreamMapper;
import mydream.vo.MydreamVO;

@Service
public class MydreamService {
	
	@Autowired
	MydreamMapper mydreamMapper;
	
	public List<MydreamVO> mydream() {
		return mydreamMapper.mydream();
	}
}
