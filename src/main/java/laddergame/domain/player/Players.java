package laddergame.domain.player;

import static laddergame.domain.LadderGameInfo.DEFAULT_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

	private List<Player> players;

	private Players(List<Player> players) {
		if(players.size() < 2) {
			throw new IllegalArgumentException("2명 이상부터 가능합니다.");
		}
		this.players = players;
	}

	public static Players fromComma(String rawPlayers) {
		final List<Player> players = Arrays.stream(rawPlayers.split("[, ]+"))
				.map(Player::new)
				.collect(Collectors.toList());
		return new Players(players);
	}

	public String getFormattedPlayerNames() {
		return players.stream()
				.map(player -> player.getFomattedName())
				.collect(Collectors.joining(DEFAULT_SEPARATOR));
	}

	public int findPlayerIndex(String playerName) {
		return players.stream()
				.filter(player -> player.isSameName(playerName))
				.map(player -> players.indexOf(player))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("해당 플레이어가 존재하지 않습니다."));
	}

	public int getPlayerCount() {
		return players.size();
	}

	public Player findPlayer(int index) {
		return players.get(index);
	}
}
