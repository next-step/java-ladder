package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator {

	private static final Random random = new Random();

	public static List<Boolean> generate(int playerCount) {
		// 선이 존재하면 점은 TRUE 이고, 점의 좌측편으로 선이 그려진다.
		// 첫번째는 좌측이 없기 때문에 항상 FALSE를 가진다.
		List<Boolean> points = new ArrayList<>();
		points.add(Boolean.FALSE);
		while(points.size() < playerCount) {
			points.add(getRandomLinePoint(hasLineAtBeforePoint(points)));
		}
		return points;
	}

	private static Boolean hasLineAtBeforePoint(List<Boolean> points) {
		return points.get(points.size() - 1);
	}

	private static Boolean getRandomLinePoint(Boolean hasLineAtBeforePoint) {
		return !hasLineAtBeforePoint && random.nextBoolean();
	}
}
