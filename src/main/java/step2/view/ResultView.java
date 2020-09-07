package step2.view;

import step2.domain.Ladder;

import java.util.List;

public class ResultView {
	private static final String BLANK = "     |";
	private static final String POINT = "-----|";

	private ResultView() {}

	public static void printCreatedLadderInfo(Ladder ladder) {
		System.out.println("실행결과");

		ladder.getUsersName()
				.forEach(name -> System.out.printf("%6s", name));
		System.out.println();
		ladder.getCreatedLadder()
				.forEach(line -> System.out.println(ladderFormat(line.getPoints())));
	}

	private static String ladderFormat(List<Boolean> points) {
		StringBuilder sb = new StringBuilder();
		for (Boolean point : points) {
			sb.append(pointOrBlank(point));
		}
		return sb.toString();
	}

	private static String pointOrBlank(boolean point) {
		if (point) {
			return POINT;
		}
		return BLANK;
	}
}
