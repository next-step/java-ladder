package nextstep.ladder.application.result;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
		return prizes.getPrizes().stream()
			.collect(Collectors.toMap(
				prize -> players.playerPrizeMapFactory(prizes.prizeIndex(prize)),
				Function.identity()));
	}

	public Map<Player, Prize> getPlayerPrizes() {
		return playerPrizes;
	}

	public String printPlayerResult(String name, Players players) {
		StringBuilder builder = new StringBuilder();
		Player targetPlayer = players.findPlayerByName(name);
		if (playerPrizes.containsKey(targetPlayer)) {
			builder.append("실행 결과\n").append(playerPrizes.get(targetPlayer).getName());
		}
		return builder.toString();
	}
}
