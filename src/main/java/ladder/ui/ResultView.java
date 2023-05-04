package ladder.ui;

import java.util.stream.IntStream;

import ladder.domain.Names;

public class ResultView {

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
}
