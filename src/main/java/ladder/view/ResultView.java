package ladder.view;

import ladder.domain.Ladder;

public class ResultView {

	private ResultView() {

	}

	public static void printLadder(Ladder ladder) {
		System.out.println();
		System.out.println("실행결과");
		System.out.println(ladder);
	}

}
