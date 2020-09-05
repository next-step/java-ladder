package step2.view;

import step2.domain.Ladder;

public class ResultView {

	private ResultView() {}

	public static void printCreatedLadder(Ladder ladder) {
		System.out.println("실행결과");

		System.out.println(ladder.users());
		System.out.println(ladder.lines());
	}
}
