package mydream.mapper.song;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mydream.vo.song.SongVO;

@Mapper
public interface SongMapper {

	SongVO selectSongInfo(String songname);

	List<SongVO> selectSongWord(String songname);

	void insertSong(SongVO songvo);

	void insertSongword(String songname, String koreawords, String englishwords);

	List<SongVO> selectListSongInfo();

}
