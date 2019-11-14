package ladder.view;

import ladder.domain.LadderExecutionResult;
import ladder.domain.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.point.Point;

import java.util.List;
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
		for (int i = 1, end = getLastIndex(lines); i < end; i++) {
			printMiddleLine(lines.get(i));
		}
		printLastLine(lines.get(getLastIndex(lines)));
	}

	private static int getLastIndex(List<Line> lines) {
		return lines.size() - 1;
	}

	private static void printFirstLine(Line line) {
		List<String> names = line.getPoints().stream()
				.map(Point::getName)
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

	private static void printLastLine(Line line) {
		List<String> result = line.getPoints().stream()
				.map(point -> point.getResultFrom(Direction.VERTICAL))
				.collect(Collectors.toList());
		for (String eachResult : result) {
			System.out.print(String.format("%6s", eachResult));
		}
		System.out.println();
	}

	public static void printResult(String result) {
		System.out.println();
		System.out.println("실행결과");
		System.out.println(result);
	}

	public static void printAllResult(LadderExecutionResult resultMap) {
		System.out.println();
		System.out.println("실행결과");
		for (String name : resultMap.getNames()) {
			printEachResult(name, resultMap.getExecutionResult(name));
		}
	}

	private static void printEachResult(String name, String result) {
		System.out.println(String.format("%s : %s", name, result));
	}

}
