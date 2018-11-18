package laddergame.view;

import laddergame.domain.DisplayLadder;
import laddergame.domain.Printable;

public class ResultView {

	public static void printLadder(DisplayLadder displayLadder) {
		System.out.println("\n사다리 결과\n");
		System.out.println(displayLadder.draw());
	}

	public static void printResult(Printable printer) {
		System.out.println("\n실행 결과");
		System.out.println(printer.print());
	}
}
