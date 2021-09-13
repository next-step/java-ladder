package nextstep.ladder.ui;

import java.util.stream.IntStream;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

public class ResultView {

	public static final String GAME_RESULT = "실행결과";
	public static final String CONNECTED = "-----|";
	public static final String NOT_CONNECTED = "     |";
	public static final String SPACE = " ";
	public static final int MAX_NAME_SIZE = 5;

	public void drawResult(Participants participants, Lines lines) {
		int maxNameSize = MAX_NAME_SIZE;
		System.out.println(GAME_RESULT);

		drawNames(participants, maxNameSize);

		drawLadder(lines);
	}

	private void drawLadder(Lines lines) {
		for (Line line : lines.list()) {
			drawLine(line);
			System.out.println();
		}
	}

	private void drawLine(Line line) {
		line.blocks()
			.stream()
			.forEachOrdered(block -> {
				if (block.isConnected()) {
					System.out.print(CONNECTED);
					return;
				}
				System.out.print(NOT_CONNECTED);
			});
	}

	private void drawNames(Participants participants, int maxNameSize) {
		for (String name : participants.names()) {
			StringBuilder stringBuilder = new StringBuilder();
			IntStream
				.range(0, maxNameSize - name.length())
				.forEach(n -> stringBuilder.append(SPACE));
			stringBuilder.append(name);
			stringBuilder.append(SPACE);
			System.out.print(stringBuilder);
		}
		System.out.println();
	}
}
