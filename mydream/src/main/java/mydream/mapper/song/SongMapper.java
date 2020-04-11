package mydream.mapper.song;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mydream.vo.song.SongVO;

@Mapper
public interface SongMapper {

	SongVO selectSongInfo();

	List<SongVO> selectSongWord();
}
