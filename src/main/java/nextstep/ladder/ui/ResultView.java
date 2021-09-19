package nextstep.ladder.ui;

import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Reward;
import nextstep.ladder.domain.Rewards;

public class ResultView {

	private static final String GAME_RESULT = "실행결과";
	private static final String CONNECTED = "-----|";
	private static final String NOT_CONNECTED = "     |";
	private static final String SPACE = " ";
	private static final int MAX_NAME_SIZE = 5;

	private ResultView() {
	}

	public static void drawLadderResult(Participants participants, Ladder lines, Rewards rewards) {
		System.out.println(GAME_RESULT);

		drawNames(participants, MAX_NAME_SIZE);

		drawLadder(lines);

		drawRewards(rewards, MAX_NAME_SIZE);
	}

	private static void drawRewards(Rewards rewards, int maxNameSize) {
		for (String name : rewards.names()) {
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

	private static void drawLadder(Ladder lines) {
		for (Line line : lines.list()) {
			drawLine(line);
			System.out.println();
		}
	}

	private static void drawLine(Line line) {
		line.blocks()
			.stream()
			.forEachOrdered(block -> {
				if (block.direction() == Direction.LEFT) {
					System.out.print(CONNECTED);
					return;
				}
				System.out.print(NOT_CONNECTED);
			});
	}

	private static void drawNames(Participants participants, int maxNameSize) {
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

	public static void drawResult(LadderResult result) {
		System.out.println("실행 결과");
		System.out.println(result.reward());
	}

	public static void drawAllResult(List<LadderResult> gameResultAll) {
		System.out.println("실행 결과");
		for (LadderResult ladderResult : gameResultAll) {
			System.out.println(ladderResult.participant() + " : " + ladderResult.reward());
		}
	}
}
