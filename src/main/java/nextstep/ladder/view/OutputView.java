package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.participant.Participants;

public class OutputView {

	public void printResult(Participants participants, Ladder ladder) {
		System.out.println("실행결과");

		participants.forEach(participant -> System.out.print(participant + "  "));
		System.out.println();

		ladder.forEach(line -> {
			System.out.println(line.getLine());
		});

	}
}
