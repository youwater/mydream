package mydream.service.song;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import mydream.mapper.song.SongMapper;
import mydream.vo.song.SongVO;

@Slf4j
@Service
public class SongService {

	@Autowired
	SongMapper songMapper;

	public Object selectSongInfo(String songname) {
		SongVO songinfo =  songMapper.selectSongInfo(songname);
		songinfo.setSonglyrics(songinfo.getSonglyrics().replace("+", "'"));
		songinfo.setSongname(songinfo.getSongname().replace("+", "'"));
		
		//팝송으로 공부하기 조회수 업데이트
		songMapper.updateCountClick(songinfo.getClickcount(),songinfo.getSongname());
		
		return songinfo;
	}

	
	public Object selectSongWord(String songname) {
		List<SongVO> songword =  songMapper.selectSongWord(songname);
		return songword;
	}


	public void insertSong(SongVO songvo) {
		try {
			songvo.setSonglyrics(songvo.getSonglyrics().replace("'", "+"));
			songvo.setSongname(songvo.getSongname().replace("'", "+"));
			songMapper.insertSong(songvo);
		}catch(Exception e){
			log.error("노래 가사 등록시 에러 발생 insertSong={}",e);
		}
			
	}

	public void insertSongword(HttpServletRequest request, String songname) {
		String [] koreawords =request.getParameterValues("koreawords");
		String [] englishwords =request.getParameterValues("englishwords");
		try {
			for(int i=0; i<koreawords.length;i++) {
				if(koreawords[i] =="" || koreawords[i].equals("") || englishwords[i] =="" || englishwords[i].equals("")) {
					continue;
				}
				songMapper.insertSongword(songname,koreawords[i],englishwords[i]);
			}
		}catch(Exception e){
			log.error("노래 가사 등록시 에러 발생 insertSongword={}",e);
		}
	}


	public Object selectListSongInfo() {
		List<SongVO> songword =  songMapper.selectListSongInfo();
		return songword;
	}
}
