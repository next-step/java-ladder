package step4.view;

import step4.domain.Ladder;
import step4.domain.Point;

import java.util.Arrays;
import java.util.List;

public class ResultView {
	private static final String BLANK = "     |";
	private static final String POINT = "-----|";

	private ResultView() {}

	public static void printCreatedLadderInfo(String[] usersName, Ladder ladder, String[] results) {
		System.out.println("사다리 결과");

		Arrays.stream(usersName)
				.forEach(name -> System.out.printf("%6s", name));
		System.out.println();
		
		ladder.getCreatedLadder()
				.forEach(line -> System.out.println(ladderFormat(line.getPoints())));
		
		Arrays.stream(results)
				.forEach(result -> System.out.printf("%6s", result));
		System.out.println();
	}

	private static String ladderFormat(List<Point> points) {
		StringBuilder sb = new StringBuilder();
		for (Point point : points) {
			sb.append(pointOrBlank(point.isPoint()));
		}
		return sb.toString();
	}

	private static String pointOrBlank(boolean point) {
		if (point) {
			return POINT;
		}
		return BLANK;
	}
	
	public static void printGameResult(List<String> result) {
		System.out.println("실행 결과");
		result.forEach(System.out::println);
	}

	public static void printGameResult(String result) {
		System.out.println("실행 결과");
		System.out.println(result);
	}
}
