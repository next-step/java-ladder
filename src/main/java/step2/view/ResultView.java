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
		ladder.getCreatedLadder()
				.forEach(line -> System.out.println(ladderFormat(line.getPoints())));
	}

	private static String ladderFormat(List<Boolean> points) {
		StringBuilder sb = new StringBuilder();
		for (Boolean point : points) {
			if (point) {
				sb.append(POINT);
			} else {
				sb.append(BLANK);
			}
		}
		return sb.toString();
	}
}
