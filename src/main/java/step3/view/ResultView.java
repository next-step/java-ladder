package step3.view;

import step3.domain.Ladder;

import java.util.Arrays;
import java.util.List;

public class ResultView {
	private static final String BLANK = "     |";
	private static final String POINT = "-----|";

	private ResultView() {}

	public static void printCreatedLadderInfo(String[] usersName, Ladder ladder) {
		System.out.println("사다리 결과");

		Arrays.stream(usersName)
				.forEach(name -> System.out.printf("%6s", name));
		System.out.println();
		ladder.getCreatedLadder()
				.forEach(line -> System.out.println(ladderFormat(line.getPoints())));
	}

	private static String ladderFormat(List<Boolean> points) {
		StringBuilder sb = new StringBuilder();
		for (Boolean isPoint : points) {
			sb.append(pointOrBlank(isPoint));
		}
		return sb.toString();
	}

	private static String pointOrBlank(boolean point) {
		if (point) {
			return POINT;
		}
		return BLANK;
	}

	public static void printGameResult(String name) {
		System.out.println("실행 결과");


	}
}
