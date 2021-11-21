package nextstep.ladder.view;

import java.util.List;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Point;
import nextstep.ladder.exception.UtilCreationException;

public final class ResultView {
	private static final StringBuilder BUILDER = new StringBuilder();

	private static final String EXECUTION_RESULT = "사다리 결과";

	private static final String NAME_FORMAT = "%6s";
	private static final String RESULT_FORMAT = "%6s";

	private static final String LADDER_EXIST_LINE = "-----|";
	private static final String LADDER_EMPTY_LINE = "     |";

	private ResultView() {
		throw new UtilCreationException();
	}

	public static void printTitle() {
		initializeBuilder();

		appendToBuilder(EXECUTION_RESULT);
		appendNewlineToBuilder();

		printBuilder();
	}

	public static void printParticipants(List<Participant> participants) {
		initializeBuilder();
		participants.forEach(participant -> appendToBuilder(String.format(NAME_FORMAT, participant)));
		printBuilder();
	}

	public static void printLadder(List<Line> lines) {
		initializeBuilder();

		lines.forEach(line -> {
			appendLadderLine(line.getPoints());
			appendNewlineToBuilder();
		});

		printBuilder();
	}

	private static void appendLadderLine(List<Point> points) {
		points.forEach(ResultView::appendLine);
	}

	private static void appendLine(Point point) {
		String line = LADDER_EMPTY_LINE;
		if (point.hasLeft()) {
			line = LADDER_EXIST_LINE;
		}
		appendToBuilder(line);
	}

	public static void printExecutionResult(List<String> results) {
		initializeBuilder();
		results.forEach(result -> appendToBuilder(String.format(RESULT_FORMAT, result)));
		printBuilder();
	}

	private static void initializeBuilder() {
		BUILDER.setLength(0);
	}

	private static void appendToBuilder(Object input) {
		BUILDER.append(input);
	}

	private static void appendNewlineToBuilder() {
		appendToBuilder(System.lineSeparator());
	}

	private static void printBuilder() {
		System.out.println(BUILDER);
	}
}
