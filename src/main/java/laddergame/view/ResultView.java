package laddergame.view;

import laddergame.domain.Ladder;

public class ResultView {

	public static void printLadder(Ladder ladder) {
		System.out.println(ladder.draw());
	}
}
