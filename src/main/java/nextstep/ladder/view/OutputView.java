package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Results;
import nextstep.ladder.domain.participant.Participants;

public class OutputView {

	private static final String LINE = "-";
	private static final String BLANK = " ";
	private static final Integer MAX_NAME_LENGTH = 5;

	public void printLadder(Participants participants, Ladder ladder, Results results) {
		System.out.println("사다리 결과");

		participants.getNames()
			.forEach(participant -> System.out.print(getInput(participant)));
		System.out.println();

		ladder.getLadder()
				.forEach(line -> System.out.println(getLine(line)));

		results.getResults()
			.forEach(result -> System.out.print(getInput(result)));
		System.out.println();
	}

	public void printResultHeader() {
		System.out.println("실행 결과");
	}

	public void printResult(String result) {
		System.out.println(result);
	}

	public void printNameAndResult(String name, String result) {
		System.out.println(name + " : " + result);
	}

	private StringBuilder getInput(String input) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(BLANK.repeat(MAX_NAME_LENGTH - input.length() + 1));
		stringBuilder.append(input);
		return stringBuilder;
	}

	private StringBuilder getLine(Line line) {
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
			mark = LINE;
		} else {
			mark = BLANK;
		}
		stringBuilder.append(mark.repeat(MAX_NAME_LENGTH));
	}
}
