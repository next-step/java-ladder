package nextstep.ladder.application.result;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import nextstep.ladder.application.prize.Prize;
import nextstep.ladder.application.prize.Prizes;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

public class GameResult {

	private final Map<Player, Prize> playerPrizes;

	private GameResult(Players players, Prizes prizes) {
		this.playerPrizes = playerPrizeMapFactory(players, prizes);
	}

	public static GameResult ofPlayersAndPrizes(Players players, Prizes prizes) {
		return new GameResult(players, prizes);
	}

	private Map<Player, Prize> playerPrizeMapFactory(Players players, Prizes prizes) {
		AtomicInteger prizeIndex = new AtomicInteger(0);
		return Collections.emptyMap();

		// return prizes.getPrizes().stream()
		// 	.map(players.getPlayers().stream().map(
		// 		player -> prizeIndex.get() == player.getPosition()
		// 	)), Function.identity());

		// IntStream.range(0, prizes.getPrizes().size())
		// 	.mapToObj(index -> {
		// 		return players.getPlayers().stream()
		// 			.map(player -> index == player.getPosition());
		// 	}).collect(Collectors.toMap())
		// .collect(HashMap::new, (m, i) -> )

		// return prizes.getPrizes().stream()
		// 	.peek(prize -> {
		// 		players.getPlayers().stream()
		// 			.map(player -> prizeIndex.intValue() == player.getPosition())
		// 			.findFirst();
		// 	}).
	}

	public Map<Player, Prize> getPlayerPrizes() {
		return playerPrizes;
	}
}
