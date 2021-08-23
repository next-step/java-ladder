package nextstep.ladder.view;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Point;

public class ResultView {

	private static final String SPACING_WORDS = " ";
	private static final int INITIAL_INDEX = 0;
	private static final int LENGTH_OF_NAME_FOR_OUTPUT = 6;
	private static final String START_POSITION = "     ";
	private static final String POINT_WITH_LINE = "|-----";
	private static final String POINT_WITHOUT_LINE = "|     ";

	private ResultView() {
	}

	public static void printPlayerNames(Players players) {
		players.values()
			.stream()
			.map(Player::getName)
			.forEach(playerName -> System.out.print(processPlayerName(playerName)));
		printBlankLine();
	}

	public static void printLadder(Ladder ladder) {
		List<Line> lines = ladder.lines();
		lines.forEach(ResultView::printLine);
	}

	private static void printLine(Line line) {
		System.out.print(START_POSITION);
		List<Point> points = line.points();
		points.forEach(ResultView::printPoint);
		printBlankLine();
	}

	private static void printPoint(Point point) {
		if (point.isRightward()) {
			System.out.print(POINT_WITH_LINE);
			return;
		}
		System.out.print(POINT_WITHOUT_LINE);
	}

	private static String processPlayerName(String playerName) {
		StringBuilder builder = new StringBuilder();
		for (int i = INITIAL_INDEX; i < LENGTH_OF_NAME_FOR_OUTPUT - playerName.length(); i++) {
			builder.append(SPACING_WORDS);
		}
		builder.append(playerName);
		return builder.toString();
	}

	private static void printBlankLine() {
		System.out.println();
	}
}
