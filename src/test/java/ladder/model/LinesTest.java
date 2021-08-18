package ladder.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
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

	@Test
	@DisplayName("라인의 시작위치를 입력하면 최종 위치를 알 수 있다.")
	public void findResultPosition() {
		Lines lines = new Lines(getLine());

		assertThat(lines.findResultPosition(1)).isEqualTo(2);
	}

	private List<Line> getLine() {
		List<Line> lines = new ArrayList<>();
		lines.add(new Line(getPoints(false, false, true)));
		lines.add(new Line(getPoints(false, true, false)));
		lines.add(new Line(getPoints(true, true, false)));
		return lines;
	}

	private List<Boolean> getPoints(boolean value1, boolean value2, boolean value3) {
		return Arrays.asList(value1, value2, value3);
	}

}