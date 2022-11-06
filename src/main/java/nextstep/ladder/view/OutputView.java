package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.participant.Participants;

public class OutputView {

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
		stringBuilder.append("|");
		line.getPoints().forEach(point -> appendLine(point, stringBuilder));
		return stringBuilder;
	}

	private void appendLine(Boolean point, StringBuilder stringBuilder) {
		if (point){
			stringBuilder.append("------");
		}
		else{
			stringBuilder.append("      ");
		}
		stringBuilder.append("|");
	}
}
