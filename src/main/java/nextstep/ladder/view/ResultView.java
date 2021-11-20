package nextstep.ladder.view;

import java.util.List;

import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Point;
import nextstep.ladder.exception.UtilCreationException;

public final class ResultView {
	private static final StringBuilder BUILDER = new StringBuilder();

	private static final int ONE = 1;
	private static final int ZERO = 0;

	private static final String EXECUTION_RESULT = "사다리 결과";

	private static final String NAME_FORMAT = "%6s";
	private static final String RESULT_FORMAT = "%6s";

	private static final String LADDER_LEFT_PADDING = "    ";
	private static final String LADDER_EXIST_LINE = "|-----";
	private static final String LADDER_EMPTY_LINE = "|     ";

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

	public static void printLadder(List<Point> points, int width) {
		initializeBuilder();

		for (int i = ZERO; i < points.size(); i++) {
			appendPadding(width, i);
			appendLadderLine(points.get(i));
			appendNewLine(width, i);
		}

		printBuilder();
	}

	private static void appendPadding(int width, int index) {
		if (isFistIndexOfLine(index, width)) {
			appendToBuilder(LADDER_LEFT_PADDING);
		}
	}

	private static boolean isFistIndexOfLine(int index, int width) {
		return index % width == ZERO;
	}

	private static void appendLadderLine(Point point) {
		String line = LADDER_EMPTY_LINE;
		if (point.hasRight()) {
			line = LADDER_EXIST_LINE;
		}
		appendToBuilder(line);
	}

	private static void appendNewLine(int width, int index) {
		if (isLastIndexOfLine(index, width)) {
			appendNewlineToBuilder();
		}
	}

	private static boolean isLastIndexOfLine(int index, int width) {
		return (index + ONE) % width == ZERO;
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
