package mydream.vo.song;

import java.util.Date;

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
	Date songreleasedate;
	String koreaword;
	String englishword;
}
