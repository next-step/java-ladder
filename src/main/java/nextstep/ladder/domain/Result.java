package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

	private final Players players;
	private Map<Integer, Integer> result = new HashMap<>();

	public Result(Players players) {
		this.players = players;
	}

	public void put(Integer start, Integer destination) {
		result.put(start, destination);
	}

	public Integer destination(Integer start) {
		return result.get(start);
	}

	public Integer of(Player player) {
		return result.get(players.indexOf(player));
	}

}
