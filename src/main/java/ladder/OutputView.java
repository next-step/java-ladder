package ladder;

import java.util.List;
import java.util.Scanner;

public class OutputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	private OutputView() {}

	public static void printResult(Players players, LadderLines ladderLines, Prizes prizes, PositionLogs positionLogs) {
		printPlayers(players);
		printLadderLines(ladderLines);
		printPrizes(prizes);
		checkResult(players, prizes, positionLogs);
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

	private static void printPrizes(Prizes prizes) {
		for (Prize prize : prizes.getContent()) {
			System.out.printf("%-6s", prize.getName());
		}
		System.out.println();
	}

	private static void checkResult(Players players, Prizes prizes, PositionLogs positionLogs) {
		System.out.println("결과를 보고 싶은 사람은?");

		int playerIndex = players.findIndexByName(SCANNER.nextLine());
		int lastPosition = positionLogs.getLastPosition(playerIndex);
		List<Prize> prizeList = prizes.getContent();
		Prize prize = prizeList.get(lastPosition);

		System.out.println(prize.getName());
	}
}
