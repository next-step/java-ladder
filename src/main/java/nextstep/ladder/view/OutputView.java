package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.participant.Participants;

public class OutputView {

	private static final String HAS_LINE_MARK = "-";
	private static final String HAS_NOT_LINE_MARK = " ";
	private static final Integer MAX_NAME_LENGTH = 5;

	public void printResult(Participants participants, Ladder ladder) {
		System.out.println("실행결과");

		participants.getNames()
			.forEach(participant -> System.out.print(participant + "  "));
		System.out.println();

		ladder.getLadder()
				.forEach(line -> System.out.println(getLine(line)));
	}

	public StringBuilder getLine(Line line) {
		StringBuilder stringBuilder = new StringBuilder();
		appendLine(false, stringBuilder);
		line.getPoints().forEach(point -> {
			stringBuilder.append("|");
			appendLine(point, stringBuilder);
		});
		stringBuilder.append("|");
		return stringBuilder;
	}

	private void appendLine(Boolean point, StringBuilder stringBuilder) {
		String mark;
		if (point) {
			mark = HAS_LINE_MARK;
		} else {
			mark = HAS_NOT_LINE_MARK;
		}
		stringBuilder.append(mark.repeat(MAX_NAME_LENGTH));
	}
}
