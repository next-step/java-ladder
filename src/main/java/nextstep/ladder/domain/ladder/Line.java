package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line{

	private static Random RANDOM = new Random();
	private List<Boolean> points = new ArrayList<>();

	public Line (int length) {
		IntStream.range(0, length - 1).forEach(this::addPoint);
	}

	public List<Boolean> getPoints() {
		return this.points;
	}

	/**
	 * 현재 포인트에 true / false 가 올 수 있는 경우를 체크하는 메서드
	 * 이전 포인트가 없거나(첫번째) 또는 이전 포인트가 false(라인이 없음)
	 */
	private Boolean isAvailablePoint(int index) {
		return points.isEmpty() || !points.get(index - 1);
	}

	private void addPoint(int index) {
		Boolean point = RANDOM.nextBoolean();
		if (isAvailablePoint(index)) {
			points.add(point);
			return;
		}
		points.add(false);
	}
}