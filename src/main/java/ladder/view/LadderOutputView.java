package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.model.GameResult;
import ladder.model.Line;
import ladder.model.Lines;
import ladder.model.Players;
import ladder.model.Point;
import ladder.model.Results;

public class LadderOutputView {

	private static final String SPACE_NAME = " ";
	private static final int LIMIT_LENGTH = 6;
	private static final String GAME_RESULT_START = "실행결과";
	private static final String NOTHING_LINE = "     |";
	private static final String EXIST_LINE = "-----|";

	public static void printLadderGameResultStart() {
		System.out.println(GAME_RESULT_START);
		System.out.print("\n");
	}

	public static void printPlayersName(Players players) {
		System.out.println(players.getPlayers()
			.stream()
			.map(player -> applyNameLength(player.getPlayerName()))
			.collect(Collectors.joining()));
	}

	public static void printResultCreateLadder(Lines ladderLines) {
		ladderLines.getLadder()
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

	private static String drawLine(Point point) {
		if (point.isLeft()) {
			return EXIST_LINE;
		}
		return NOTHING_LINE;
	}

	public static void printResultsName(Results results) {
		System.out.println(results.getResults()
			.stream()
			.map((result) -> applyNameLength(result.getResult()))
			.collect(Collectors.joining()));
	}

	private static String applyNameLength(String name) {
		return Stream.generate(() -> SPACE_NAME)
			.limit(LIMIT_LENGTH - name.length())
			.collect(Collectors.joining())
			.concat(name);
	}

	public static void printResultLadderGame(List<GameResult> gameResults, Results results) {
		gameResults.stream()
			.map(gameResult ->
				gameResult.getPlayer().getPlayerName() + " : " + results.findResult(
					gameResult.getPosition()))
			.forEach(System.out::println);
		System.out.print("\n");
	}
}
