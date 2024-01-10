package ladder.view;

import ladder.domain.Direction;
import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.People;

public class ResultView {
	public static void printLadder(People people, Lines ladder) {
		printTitle(people);
		ladder.line().forEach(ResultView::drawLine);
	}

	private static void printTitle(People people) {
		System.out.printf("실행결과%n%n");

		people.values().forEach(item -> System.out.printf(String.format("%5s ", item)));
		System.out.println();
	}

	private static void drawLine(Line ladderLine) {
		ladderLine.draw().forEach(item -> System.out.print(drawPoint(item)));
		System.out.println();
	}

	private static String drawPoint(Direction direction) {
		if (direction.isLeft()) {
			return "-----|";
		}
		return "     |";
	}
}
