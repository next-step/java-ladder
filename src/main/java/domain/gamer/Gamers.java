package domain.gamer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 18/11/2018.
 */
public class Gamers {
	private List<Gamer> gamers;

	public Gamers(List<String> gamerValues) {
		this.gamers = initGamer(gamerValues);
	}

	public int size() {
		return gamers.size();
	}

	private List<Gamer> initGamer(List<String> gamerNameList) {
		List<Gamer> gamers = new ArrayList<>();
		int position = 0;
		for (String gamerName : gamerNameList) {
			gamers.add(new Gamer(gamerName, position++));
		}
		return gamers;
	}

	public Gamer findByGamerName(String gamerName) {
		return gamers.stream().filter(gamer -> gamer.isEqualName(gamerName)).findFirst().orElseThrow(IllegalAccessError::new);
	}

	public List<Gamer> getGamerList() {
		return Collections.unmodifiableList(gamers);
	}

}
