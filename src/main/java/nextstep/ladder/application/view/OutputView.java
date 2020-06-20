package nextstep.ladder.application.view;

import nextstep.ladder.application.prize.Prizes;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.point.Points;

public class OutputView {

	private OutputView() {
	}

	public static void printLadder(Ladder ladder) {
		printPlayers(ladder.getPlayers());
		printLines(ladder.getLines());
	}

	private static void printPlayers(Players players) {
		players.printPlayers();
	}

	private static void printLines(Lines lines) {
		lines.printLines();
	}

	public static void printPoints(Points points) {
		points.printPoints();
	}

	public static void printPrizes(Prizes prizes) {
		prizes.printPrizes();
	}
}
