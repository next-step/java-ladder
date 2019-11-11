package ladder.view;

import ladder.domain.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.point.Point;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResultView {

	private ResultView() {

	}

	public static void printLadder(Ladder ladder) {
		System.out.println();
		System.out.println("실행결과");
		printLines(ladder.getLines());
	}

	private static void printLines(List<Line> lines) {
		printFirstLine(lines.get(0));
		for (int i = 1, end = lines.size() - 1; i < end; i++) {
			printMiddleLine(lines.get(i));
		}
	}

	private static void printFirstLine(Line line) {
		List<String> names = line.getPoints().stream()
				.map(Point::getName)
				.map(Optional::get)
				.collect(Collectors.toList());
		for (String name : names) {
			System.out.print(String.format("%6s", name));
		}
		System.out.println();
	}

	private static void printMiddleLine(Line line) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("     ");
		for (Point point : line.getPoints()) {
			stringBuilder.append(visualizePoint(point));
		}
		System.out.println(stringBuilder.toString());
	}


	private static String visualizePoint(Point point) {
		if (point.hasConnection(Direction.HORIZONTAL)) {
			return "|-----";
		}
		return "|     ";
	}

}
