package ladder.dto;

import java.util.Collections;
import java.util.List;

public class LineDto {

	private final List<Boolean> points;

	private LineDto(List<Boolean> points) {
		this.points = Collections.unmodifiableList(points);
	}

	public static LineDto of(List<Boolean> points) {
		return new LineDto(points);
	}

	public List<Boolean> values() {
		return points;
	}
}
