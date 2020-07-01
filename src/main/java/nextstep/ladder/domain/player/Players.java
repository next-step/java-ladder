package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.List;

import nextstep.ladder.application.prize.Prize;
import nextstep.ladder.application.prize.Prizes;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.util.CustomCollectionUtils;

public class Players {

	private final List<Player> players;

	private Players(List<Player> players) {
		this.players = players;
	}

	public static Players ofPlayers(List<Player> players) {
		validatePlayerNumIsLargerThanZero(players);
		validatePlayerNameDistinct(players);
		// validatePlayerPositionNotExceedSize(players);
		validatePlayerCurrentPositionNotExceedSize(players);
		return new Players(players);
	}

	private static void validatePlayerNumIsLargerThanZero(List<Player> players) {
		if (CustomCollectionUtils.isNull(players) || CustomCollectionUtils.isEmpty(players)) {
			throw new IllegalArgumentException(
				"Players count should be larger than one. Otherwise, you can't play this game XD");
		}
	}

	private static void validatePlayerNameDistinct(List<Player> players) {
		if (getDistinctNameCount(players) != players.size()) {
			throw new IllegalArgumentException("please double check whether player name is not distinct.");
		}
	}

	private static void validatePlayerCurrentPositionNotExceedSize(List<Player> players) {
		if (players.stream().anyMatch(player -> ! player.validateCurrentPosition(players.size()))) {
			throw new IllegalArgumentException("please check your player position. It cannot exceed overall size.");
		}
	}

	public int getSize() {
		return players.size();
	}

	public static Long getDistinctNameCount(List<Player> players) {
		return players.stream()
			.map(Player::getName)
			.distinct()
			.count();
	}

	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	public String printPlayers() {
		StringBuilder builder = new StringBuilder();
		players.forEach(player -> builder.append(String.format("%-6s", player.getName())));
		return builder.toString();
	}

	public Players determinePlayersCurrentPositionResult(Line line) {
		this.players.forEach(player -> {
			Position newPoint = line.movePosition(player.getCurrentPosition());
			player.updateCurrentPosition(newPoint);
		});
		return this;
	}

	public Player playerPrizeMapFactory(Prizes prizes, Prize prize) {
		return players.stream()
			.filter(player -> player.getCurrentPosition().getPosition() == prizes.prizeIndex(prize))
			.findFirst()
			.map(player -> player.updatePrize(prize))
			.orElseThrow(() -> new IllegalArgumentException("no user"));
	}

	public Player findPlayerByName(String playerName) {
		return players.stream()
			.filter(player -> player.getName().equals(playerName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
	}

	public StringBuilder printResults() {
		StringBuilder stringBuilder = new StringBuilder();
		players.forEach(
			player -> stringBuilder.append(player.getName()).append(":").append(player.getPrize().getName()));
		return stringBuilder;
	}
}
