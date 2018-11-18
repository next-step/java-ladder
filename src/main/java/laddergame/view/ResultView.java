package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.LadderFinalResult;
import laddergame.domain.LadderResult;

public class ResultView {

	public static void printLadder(Ladder ladder) {
		System.out.println("\n사다리 결과\n");
		System.out.println(ladder.draw());
	}

	public static void printResult(LadderResult ladderResult) {
		System.out.println("\n실행 결과");
		System.out.println(ladderResult.getResult());
	}

	public static void printFailMessage(String message) {
		System.out.println("\n실행 결과");
		System.out.println(message);
	}

	public static void printFinalResult(LadderFinalResult ladderFinalResult) {
		System.out.println("\n실행 결과");
		for (LadderResult ladderResult : ladderFinalResult.getLadderResults()) {
			System.out.println(ladderResult.getFormattedResult());
		}
	}
}
