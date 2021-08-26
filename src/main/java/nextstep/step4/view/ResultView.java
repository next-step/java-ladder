package nextstep.step4.view;

import java.util.List;

import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.Line;
import nextstep.step4.domain.Player;
import nextstep.step4.domain.Players;
import nextstep.step4.domain.Point;
import nextstep.step4.domain.Prizes;
import nextstep.step4.domain.Result;

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
	private static final String ALL_PLAYERS = "all";

	private ResultView() {
	}

	public static void playerNames(Players players) {
		System.out.println(MESSAGE_LADDER_RESULT);
		blankLine();
		players.names().forEach(playerName -> System.out.print(processWordLength(playerName)));
		blankLine();
	}

	public static void prizes(Prizes prizes) {
		prizes.values().forEach(prize -> System.out.print(processWordLength(prize)));
		blankLine();
	}

	public static void ladder(Ladder ladder) {
		ladder.lines().forEach(ResultView::line);
	}

	private static void line(Line line) {
		System.out.print(START_POSITION);
		line.points().forEach(ResultView::point);
		blankLine();
	}

	private static void point(Point point) {
		if (point.isRight()) {
			System.out.print(POINT_WITH_LINE);
			return;
		}
		System.out.print(POINT_WITHOUT_LINE);
	}

	public static void resultOfPlayer(Result result, String playerName) {
		System.out.println(MESSAGE_RESULT_OF_PLAYERS);
		if (playerName.equals(ALL_PLAYERS)) {
			resultOfAll(result);
			return;
		}
		System.out.println(result.of(new Player(playerName)));
	}

	private static void resultOfAll(Result result) {
		result.value().forEach((player, prize) ->
			System.out.printf(MESSAGE_FORMAT_PRIZE_OF_PLAYER, player.name(), prize.value()));
	}

	private static String processWordLength(String word) {
		StringBuilder builder = new StringBuilder();
		for (int i = INITIAL_INDEX; i < LENGTH_OF_WORD_FOR_OUTPUT - word.length(); i++) {
			builder.append(SPACING_WORDS);
		}
		builder.append(word);
		return builder.toString();
	}

	private static void blankLine() {
		System.out.println();
	}
}
