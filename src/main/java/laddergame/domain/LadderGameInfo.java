package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameInfo {

	public static final String DEFAULT_SEPARATOR = " ";

	private List<Player> players;
	private List<Result> results;

	public LadderGameInfo(List<Player> players, List<Result> results) {
		if(players.size() != results.size()) {
			throw new IllegalArgumentException("플레이어와 결과의 수가 다릅니다.");
		}
		this.players = players;
		this.results = results;
	}

	public String getPlayerNames() {
		return players.stream()
				.map(player -> player.getFomattedName())
				.collect(Collectors.joining(DEFAULT_SEPARATOR));
	}

	public String getResults() {
		return results.stream()
				.map(result -> result.getFormattedValue())
				.collect(Collectors.joining(DEFAULT_SEPARATOR));
	}
}
