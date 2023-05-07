package ladder.ui;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.Point;
import ladder.domain.Points;

public class ResultView {

	private static final String HEIGHT_TEXT = "|";
	private static final String TRUE_TEXT = String.join("", Collections.nCopies(Names.LENGTH_MAXIMUM, "-"));
	private static final String FALSE_TEXT = String.join("", Collections.nCopies(Names.LENGTH_MAXIMUM, " "));

	public static void printNames(Names names) {
		System.out.println("\n실행결과");
		StringBuilder stringBuilder = new StringBuilder();
		for (Name name : names.getNames()) {
			stringBuilder.append(ResultView.nameBlank(name.getName()));
			stringBuilder.append(name.getName());
		}
		System.out.println(stringBuilder);
	}

	private static String nameBlank(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		IntStream.range(0, Names.LENGTH_MAXIMUM + 1 - name.length())
			.forEach(i -> stringBuilder.append(" "));
		return stringBuilder.toString();
	}

	public static void printLadder(Ladder ladder) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Line line : ladder.getLines()) {
			stringBuilder.append(ResultView.ladderBlank());
			stringBuilder.append(ResultView.lineText(line.getPoints()));
			stringBuilder.append("\n");
		}
		System.out.println(stringBuilder);
	}

	private static String ladderBlank() {
		StringBuilder stringBuilder = new StringBuilder();
		IntStream.range(0, Names.LENGTH_MAXIMUM)
			.forEach(i -> stringBuilder.append(" "));
		return stringBuilder.toString();
	}

	private static String lineText(Points points) {
		return points.getPoints().stream()
			.map(point -> {
				if (point.equals(Point.of(true))) {
					return ResultView.TRUE_TEXT;
				}
				return ResultView.FALSE_TEXT;
			})
			.collect(Collectors.joining(ResultView.HEIGHT_TEXT, ResultView.HEIGHT_TEXT, ResultView.HEIGHT_TEXT));
	}
}
