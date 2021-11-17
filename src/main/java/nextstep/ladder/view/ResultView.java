package nextstep.ladder.view;

import java.util.List;

import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Point;
import nextstep.ladder.exception.UtilCreationException;

public final class ResultView {
	private static final StringBuilder BUILDER = new StringBuilder();

	private static final int ONE = 1;
	private static final int ZERO = 0;

	private static final String EXECUTION_RESULT = "실행 결과";

	private static final String NAME_FORMAT = "%6s";

	private static final String LADDER_LEFT_PADDING = "    ";
	private static final String LADDER_EXIST_LINE = "|-----";
	private static final String LADDER_EMPTY_LINE = "|     ";

	private ResultView() {
		throw new UtilCreationException();
	}

	public static void printNames(List<Participant> participants) {
		initializeBuilder();

		appendToBuilder(EXECUTION_RESULT);
		appendNewlineToBuilder();

		participants.forEach(participant -> appendToBuilder(String.format(NAME_FORMAT, participant)));
		appendNewlineToBuilder();

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

	private static void appendPadding(int width, int idx) {
		if (isFistIndexOfLine(idx, width)) {
			appendToBuilder(LADDER_LEFT_PADDING);
		}
	}

	private static boolean isFistIndexOfLine(int idx, int width) {
		return idx % width == ZERO;
	}

	private static void appendLadderLine(Point point) {
		String line = LADDER_EMPTY_LINE;
		if (point.hasLine()) {
			line = LADDER_EXIST_LINE;
		}
		appendToBuilder(line);
	}

	private static void appendNewLine(int width, int idx) {
		if (isLastIndexOfLine(idx, width)) {
			appendNewlineToBuilder();
		}
	}

	private static boolean isLastIndexOfLine(int idx, int width) {
		return (idx + ONE) % width == ZERO;
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
