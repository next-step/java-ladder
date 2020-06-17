package nextstep.ladder.game;

import nextstep.ladder.ladder.Ladder;
import nextstep.ladder.line.Lines;
import nextstep.ladder.player.Players;
import nextstep.ladder.point.Points;

public class OutputView {

	private OutputView() {
	}

	public static void printLadder(Ladder ladder) {
		printPlayers(ladder.getPlayers());
		printLines(ladder.getLines());
	}

	private static void printPlayers(Players players) {
		players.getPlayers().forEach(
			player -> System.out.printf("%-6s", player.getName())
		);
		System.out.println();
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
		points.getPoints()
			.forEach(point -> {
					System.out.print("|");
					System.out.printf("%-5s", point.isConnectedToNextPoint() ? "-----" : "");
				}
			);
	}
}
