package nextstep.ladder.application.view;

import nextstep.ladder.application.prize.Prizes;
import nextstep.ladder.application.result.GameResult;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.point.Points;

public class OutputView {

	private OutputView() {
	}

	private static final String ALL_KEYWORD = "all";

	public static void printLadder(Ladder ladder) {
		printPlayers(ladder.getPlayers());
		printLines(ladder.getLines());
	}

	private static void printPlayers(Players players) {
		System.out.println(players.printPlayers());
	}

	private static void printLines(Lines lines) {
		lines.getLines().forEach(line -> printPoints(line.getPoints()));
	}

	public static void printPoints(Points points) {
		System.out.println(points.printPoints());
	}

	public static void printPrizes(Prizes prizes) {
		System.out.println(prizes.printPrizes());
		System.out.println();
	}

	public static void printPlayerResult(GameResult gameResult, Players players) {
		String playerName = InputView.askPlayerName();
		System.out.println(playerName);
		if (playerName.equals(ALL_KEYWORD)) {
			printResults(gameResult);
		}
		gameResult.printPlayerResult(playerName, players);
	}

	public static void printResults(GameResult result) {
		System.out.println(result.toString());
	}
}
