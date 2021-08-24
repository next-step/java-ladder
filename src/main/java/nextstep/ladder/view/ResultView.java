package nextstep.ladder.view;

import java.util.List;
import java.util.Map;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Result;

public class ResultView {

	private static final String MESSAGE_LADDER_RESULT = System.lineSeparator() + "사다리 결과";
	private static final String MESSAGE_RESULT_OF_PLAYERS = System.lineSeparator() + "실행 결과";
	private static final String MESSAGE_FORMAT_PRIZE_OF_PLAYER = "%s : %s%n";
	private static final String SPACING_WORDS = " ";
	private static final int INITIAL_INDEX = 0;
	private static final int LENGTH_OF_WORD_FOR_OUTPUT = 6;
	private static final String START_POSITION = "     ";
	private static final String POINT_WITH_LINE = "|-----";
	private static final String POINT_WITHOUT_LINE = "|     ";

	private ResultView() {
	}

	public static void printPlayerNames(Players players) {
		System.out.println(MESSAGE_LADDER_RESULT);
		printBlankLine();
		players.values()
			.stream()
			.map(Player::getName)
			.forEach(playerName -> System.out.print(processWordLength(playerName)));
		printBlankLine();
	}

	public static void printLadder(Ladder ladder) {
		List<Line> lines = ladder.lines();
		lines.forEach(ResultView::printLine);
	}

	public static void printPrizes(List<String> prizes) {
		prizes.forEach(prize -> System.out.print(processWordLength(prize)));
		printBlankLine();
	}

	public static void printPrizeOfPlayer(Result result, List<String> prizes, String playerName) {
		System.out.println(MESSAGE_RESULT_OF_PLAYERS);
		System.out.println(prizes.get(result.of(new Player(playerName))));
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

	private static String processWordLength(String word) {
		StringBuilder builder = new StringBuilder();
		for (int i = INITIAL_INDEX; i < LENGTH_OF_WORD_FOR_OUTPUT - word.length(); i++) {
			builder.append(SPACING_WORDS);
		}
		builder.append(word);
		return builder.toString();
	}

	private static void printBlankLine() {
		System.out.println();
	}
}
