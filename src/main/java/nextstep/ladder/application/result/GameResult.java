package nextstep.ladder.application.result;

import java.util.Iterator;
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
				Function.identity()
			));
	}

	public Map<Player, Prize> getPlayerPrizes() {
		return playerPrizes;
	}

	public void printPlayerResult(String name, Players players) {
		Player targetPlayer = players.findPlayerByName(name);
		if (playerPrizes.containsKey(targetPlayer)) {
			System.out.println("실행 결과\n" + playerPrizes.get(targetPlayer).getName());
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("실행 결과\n");
		Iterator<Map.Entry<Player, Prize>> playerPrize = this.playerPrizes.entrySet().stream().iterator();
		while (playerPrize.hasNext()) {
			Map.Entry<Player, Prize> entry = playerPrize.next();
			stringBuilder.append(entry.getKey().getName() + ":" + entry.getValue().getName() + "\n");
		}
		return stringBuilder.toString();
	}
}
