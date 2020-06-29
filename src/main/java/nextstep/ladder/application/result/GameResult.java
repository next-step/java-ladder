package nextstep.ladder.application.result;

import static java.util.stream.Collectors.*;

import java.util.stream.Collectors;

import nextstep.ladder.application.prize.Prizes;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

public class GameResult {

	private final Players playersAfterPlayingLadderGame;

	private GameResult(Players players, Prizes prizes) {
		this.playersAfterPlayingLadderGame = playerPlayingResultFactory(players, prizes);
	}

	public static GameResult ofPlayersAndPrizes(Players players, Prizes prizes) {
		return new GameResult(players, prizes);
	}

	private Players playerPlayingResultFactory(Players players, Prizes prizes) {
		return prizes.getPrizes().stream()
			.map(prize -> players.playerPrizeMapFactory(prizes, prize))
			.collect(collectingAndThen(Collectors.toList(), Players::ofPlayers));
	}

	public Players getPlayersAfterPlayingLadderGame() {
		return playersAfterPlayingLadderGame;
	}

	public String printPlayerResult(String name, Players players) {
		StringBuilder builder = new StringBuilder("실행 결과\n");
		Player targetPlayer = players.findPlayerByName(name);
		builder.append(targetPlayer.getPrize().getName());
		return builder.toString();
	}

	public String printResults() {
		return playersAfterPlayingLadderGame.printResults().toString();
	}
}
