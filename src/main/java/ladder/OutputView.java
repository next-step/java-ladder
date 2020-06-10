package ladder;

public class OutputView {

	private OutputView() {}

	public static void printLadder(Ladder ladder) {
		printPlayers(ladder.getPlayers());
		printLadderLines(ladder.getLadderLines());
	}

	private static void printPlayers(Players players) {
		for (Player player : players.getContent()) {
			System.out.printf("%-6s", player.getName());
		}
		System.out.println();
	}

	private static void printLadderLines(LadderLines lines) {
		for (LadderLine line : lines.getContent()) {
			printLadderLinePoints(line.getLadderLinePoints());
			System.out.println();
		}
	}

	private static void printLadderLinePoints(LadderLinePoints points) {
		for (LadderLinePoint point : points.getContent()) {
			System.out.print("|");
			System.out.printf("%-5s", point.isConnectedToNextPoint() ? "-----" : "");
		}
	}
}
