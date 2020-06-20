package nextstep.ladder.application.view;

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
		lines.getLines().forEach(
			line -> {
				printPoints(line.getPoints());
				System.out.println();
			}
		);
	}

	private static void printPoints(Points points) {
		points.getPoints().forEach(point -> {
				System.out.print("|");
				System.out.printf("%-5s", point.isConnectedToNextPoint() ? "-----" : "");
			}
		);
	}
}
