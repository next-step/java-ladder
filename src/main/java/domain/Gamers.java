package domain;

import domain.dto.GamerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hspark on 18/11/2018.
 */
public class Gamers {
	private List<Gamer> gamers;

	public Gamers(List<String> gamerValues) {
		this.gamers = initGamer(gamerValues);
	}

	public void moveAllGamer(LadderLayer ladderLayer) {
		for (Gamer gamer : gamers) {
			LadderLine ladderLine = ladderLayer.getPassableLadderLine(gamer).orElseThrow(IllegalAccessError::new);
			gamer.passLine2(ladderLine);
		}
	}

	public List<GamerDTO> getDTOs() {
		return gamers.stream().map(GamerDTO::of).collect(Collectors.toList());
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
}
