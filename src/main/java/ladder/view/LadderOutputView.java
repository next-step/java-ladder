package ladder.view;

import java.util.stream.Collectors;

import ladder.model.Line;
import ladder.model.Lines;
import ladder.model.Players;

public class LadderOutputView {

	public static final String GAME_RESULT_START = "실행결과";
	private static final String NOTHING_LINE = "     |";
	private static final String EXIST_LINE = "-----|";

	public static void printLadderGameResultStart() {
		System.out.println(GAME_RESULT_START);
		System.out.print("\n");
	}

	public static void printPlayersName(Players players) {
		System.out.println(players.getPlayersName());
	}

	public static void printResultCreateLadder(Lines ladderLines) {
		ladderLines.getLines()
			.stream()
			.map(LadderOutputView::printLine)
			.forEach(System.out::println);
	}

	private static String printLine(Line line) {
		return line.getPoints()
			.stream()
			.map(LadderOutputView::drawLine)
			.collect(Collectors.joining());
	}

	private static String drawLine(boolean point) {
		if (point) {
			return EXIST_LINE;
		}
		return NOTHING_LINE;
	}
}
