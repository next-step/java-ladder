package nextstep.step4.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

	private Map<Player, Prize> result = new HashMap<>();

	public void put(Player player, Prize prize) {
		result.put(player, prize);
	}

	public Prize of(Player player) {
		return result.get(player);
	}

	public Map<Player, Prize> value() {
		return result;
	}
}
