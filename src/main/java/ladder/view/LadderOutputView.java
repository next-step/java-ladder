package ladder.view;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.model.Line;
import ladder.model.Lines;
import ladder.model.Players;

public class LadderOutputView {

	public static final String SPACE_NAME = " ";
	private static final int LIMIT_LENGTH = 6;
	public static final String GAME_RESULT_START = "실행결과";
	private static final String NOTHING_LINE = "     |";
	private static final String EXIST_LINE = "-----|";

	public static void printLadderGameResultStart() {
		System.out.println(GAME_RESULT_START);
		System.out.print("\n");
	}

	public static void printPlayersName(Players players) {
		System.out.println(players.getPlayersName()
			.stream()
			.map(player -> applyNameLength(player.getPlayerName()))
			.collect(Collectors.joining()));
	}

	private static String applyNameLength(String name) {
		return Stream.generate(() -> SPACE_NAME)
			.limit(LIMIT_LENGTH - name.length())
			.collect(Collectors.joining())
			.concat(name);
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
