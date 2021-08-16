package ladder.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

	@Test
	@DisplayName("라인들을 입력하면 여러라인을 생성한다.")
	public void createLines() {
		Lines lines = new Lines(getLine());

		assertThat(lines).isEqualTo(new Lines(getLine()));
	}

	private List<Line> getLine() {
		List<Line> lines = new ArrayList<>();
		lines.add(new Line(getPoints(false, false, true)));
		lines.add(new Line(getPoints(false, true, false)));
		lines.add(new Line(getPoints(true, false, false)));
		return lines;
	}

	private List<Boolean> getPoints(boolean value1, boolean value2, boolean value3) {
		List<Boolean> points = new ArrayList<>();
		points.add(value1);
		points.add(value2);
		points.add(value3);
		return points;
	}

}