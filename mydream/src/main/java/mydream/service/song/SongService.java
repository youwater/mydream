package mydream.service.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mydream.mapper.song.SongMapper;
import mydream.vo.song.SongVO;


@Service
public class SongService {

	@Autowired
	SongMapper songMapper;

	public Object selectsonginfo() {
		
		SongVO songinfo =  songMapper.selectSongInfo();
		songinfo.setSonglyrics(songinfo.getSonglyrics().replace("+", "'"));
		return songinfo;
	}
	
	
}
