package ladder.ui;

import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.player.Player;
import ladder.utils.StringUtil;

import java.util.stream.Collectors;

public class ResultView {

	private static final String RESULT_MESSAGE = "\n실행결과\n";
	private static final String VERTICAL_DELIMITER = "|";
	private static final String VERTICAL_DELIMITER_PREFIX = "  |";
	private static final String LINE_DASH = "-----";
	private static final String LINE_EMPTY = "     ";

	public static void printLadder(Ladder ladder) {
		printPlayers(ladder);

		ladder.getLines().stream()
		      .map(ResultView::lineToDash)
		      .collect(Collectors.toList())
		      .forEach(System.out::println);
	}

	private static String lineToDash(Line line) {
		return line.getPoints().stream()
		           .map(point -> Boolean.TRUE.equals(point) ? LINE_DASH : LINE_EMPTY)
		           .collect(Collectors.joining(VERTICAL_DELIMITER, VERTICAL_DELIMITER_PREFIX, VERTICAL_DELIMITER));
	}

	private static void printPlayers(Ladder ladder) {
		System.out.println(RESULT_MESSAGE);

		String playersName = ladder.getPlayers().stream()
		                           .map(Player::toString)
		                           .map(name -> StringUtil.rightPad(name, 6))
		                           .collect(Collectors.joining());
		System.out.println(playersName);
	}

}
