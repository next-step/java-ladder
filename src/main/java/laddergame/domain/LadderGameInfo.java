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

	public String getFormattedPlayerNames() {
		return players.stream()
				.map(player -> player.getFomattedName())
				.collect(Collectors.joining(DEFAULT_SEPARATOR));
	}

	public String getFormattedResults() {
		return results.stream()
				.map(result -> result.getFormattedValue())
				.collect(Collectors.joining(DEFAULT_SEPARATOR));
	}

	public int findPlayerIndex(String playerName) {
		for (int index = 0; index < players.size(); index++) {
			Player player = players.get(index);
			if(player.isSameName(playerName)) {
				return index;
			}
		}
		throw new IllegalArgumentException("해당 플레이어가 존재하지 않습니다.");
	}

	public int findPlayerIndex2(String playerName) {
		return players.stream()
				.filter(player -> player.isSameName(playerName))
				.map(player -> players.indexOf(player))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("해당 플레이어가 존재하지 않습니다."));
	}

	public String findResult(int index) {
		Result result = results.get(index);
		return result.toString();
	}

	public List<String> getPlayerNames() {
		return players.stream()
				.map(Player::toString)
				.collect(Collectors.toList());
	}

}
