package ladder.view;

import ladder.domain.*;
import ladder.domain.point.LadderLinePoint;
import ladder.domain.point.LadderLinePoints;

import java.util.List;
import java.util.Scanner;

public class OutputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String CHECK_ALL_RESULT_COMMAND = "all";

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
		String playerName = SCANNER.nextLine();

		if (CHECK_ALL_RESULT_COMMAND.equals(playerName)) {
			printAllResults(players, prizes, positionLogs);
			return;
		}

		printOneResult(players, prizes, positionLogs, playerName);
	}

	private static void printAllResults(Players players, Prizes prizes, PositionLogs positionLogs) {
		System.out.println("실행 결과");
		List<Player> playerList = players.getContent();

		for (int i = 0; i < players.size(); i++) {
			Player player = playerList.get(i);
			String playerName = player.getName();
			Prize prize = getPrizeByPlayerName(players, prizes, positionLogs, playerName);
			System.out.println(String.format("%s : %s", playerName, prize.getName()));
		}
	}

	private static void printOneResult(Players players, Prizes prizes, PositionLogs positionLogs, String playerName) {
		Prize prize = getPrizeByPlayerName(players, prizes, positionLogs, playerName);
		System.out.println(prize.getName());
	}

	private static Prize getPrizeByPlayerName(Players players, Prizes prizes, PositionLogs positionLogs, String playerName) {
		int playerIndex = players.findIndexByName(playerName);
		int lastPosition = positionLogs.getLastPosition(playerIndex);
		List<Prize> prizeList = prizes.getContent();
		return prizeList.get(lastPosition);
	}
}
