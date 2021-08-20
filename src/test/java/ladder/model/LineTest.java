package ladder.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

	@Test
	@DisplayName("라인의 출력여부값들을 입력하면 라인이 생성된다.")
	public void createLine() {
		Line line = new Line(getPoints());

		assertThat(line).isEqualTo(new Line(getPoints()));
	}

	private List<Point> getPoints() {

		return Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, false));
	}

	@Test
	@DisplayName("출력된 라인의 선에 따라 위치가 이동 된다.")
	public void moveLine() {
		Line line = new Line(getPoints());

		assertThat(line.move(0)).isEqualTo(1);
		assertThat(line.move(1)).isEqualTo(0);
		assertThat(line.move(2)).isEqualTo(2);
	}

}