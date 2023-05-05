package ladder.ui;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Names;
import ladder.domain.Points;

public class ResultView {

	private static final String HEIGHT_TEXT = "|";
	private static final String TRUE_TEXT = String.join("", Collections.nCopies(Names.MAX_LENGTH, "-"));
	private static final String FALSE_TEXT = String.join("", Collections.nCopies(Names.MAX_LENGTH, " "));

	public static void printNames(Names names) {
		System.out.println("\n실행결과");
		for (String name : names.getNames()) {
			ResultView.printNameBlank(name);
			System.out.print(name);
		}
		System.out.println();
	}

	private static void printNameBlank(String name) {
		IntStream.range(0, Names.MAX_LENGTH + 1 - name.length())
			.forEach(i -> System.out.print(" "));
	}

	public static void printLadder(Ladder ladder) {
		for (Line line : ladder.getLines()) {
			ResultView.printLadderBlank();
			ResultView.printLineText(line.getPoints());
		}
	}

	public static void printLineText(Points points) {
		String lineText = points.getPoints().stream()
			.map(point -> {
				if (point) {
					return ResultView.TRUE_TEXT;
				}
				return ResultView.FALSE_TEXT;
			})
			.collect(Collectors.joining(ResultView.HEIGHT_TEXT, ResultView.HEIGHT_TEXT, ResultView.HEIGHT_TEXT));

		System.out.println(lineText);
	}

	private static void printLadderBlank() {
		IntStream.range(0, Names.MAX_LENGTH)
			.forEach(i -> System.out.print(" "));
	}
}
