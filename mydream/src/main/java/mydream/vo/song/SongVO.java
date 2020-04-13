package mydream.vo.song;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongVO {

	int num;
	String songname;
	String songartist;
	String songlyrics;
	Date regDt;
	int clickcount;
	String koreaword;
	String englishword;
}
