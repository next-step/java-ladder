package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;

public class ResultView {

	public void printResultHead() {
		System.out.println();
		System.out.println("실행결과");
		System.out.println();
	}

	public void printPlayer(Players players) {
		for (Player player : players.getPlayers()) {
			String formatString = String.format("%6s", player.toString());
			System.out.print(formatString);
		}
		System.out.println();
	}

	public void printLadder(Ladder ladder) {
		ladder.getLadder().forEach((line) -> {
			System.out.print(String.format("%5s", ""));
			line.getPoints().forEach(points -> {
				if (points) {
					System.out.print(String.format("%-6s", "|-----"));
				}
				if (!points) {
					System.out.print(String.format("%-6s", "|"));
				}
			});
			System.out.println();
		});
	}
}
