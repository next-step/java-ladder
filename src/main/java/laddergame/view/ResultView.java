package laddergame.view;

import laddergame.domain.Ladder;

public class ResultView {

	public static void printLadder(Ladder ladder) {
		System.out.println("\n사다리 결과\n");
		System.out.println(ladder.draw());
	}

	public static void printResult(String result) {
		System.out.println("\n실행 결과");
		System.out.println(result);
	}
}
