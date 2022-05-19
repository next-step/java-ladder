package step2.view;

import static java.lang.System.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import step2.domain.ladder.Direction;
import step2.domain.ladder.Ladder;
import step2.domain.ladder.Line;
import step2.domain.player.Players;

public class OutputView {

	private static final String LINE_BREAK = "\n";
	private static final Map<Direction, String> DIRECTION_PRINT_MAP = new HashMap<>();

	static {
		DIRECTION_PRINT_MAP.put(Direction.LEFT, "--|  ");
		DIRECTION_PRINT_MAP.put(Direction.STRAIGHT, "  |  ");
		DIRECTION_PRINT_MAP.put(Direction.RIGHT, "  |--");
	}

	public void showCreationResult(Players players, Ladder ladder) {
		show("실행 결과 - 생성");
		showPlayersResult(players);
		showLadderResult(ladder);
	}

	private void showPlayersResult(Players players) {
		String result = players.getValues().stream()
			.map(player -> String.format("%-5s", player.getName()))
			.sorted(String::compareToIgnoreCase)
			.collect(Collectors.joining());
		show(result);
	}

	private void showLadderResult(Ladder ladder) {
		String result = ladder.getLines().stream()
			.map(this::mapToConsolePrint)
			.collect(Collectors.joining(LINE_BREAK));
		show(result);
	}

	private String mapToConsolePrint(Line line) {
		return line.getPoints()
			.stream()
			.map(point -> DIRECTION_PRINT_MAP.get(point.getDirection()))
			.collect(Collectors.joining());
	}

	private void show(String output) {
		out.println(output);
	}
}
