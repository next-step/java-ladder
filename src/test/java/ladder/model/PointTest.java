package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	@DisplayName("라인에 대한 포인트를 생성한다.")
	public void createPoint() {
		Point point = new Point(false);

		Assertions.assertThat(point).isEqualTo(new Point(false));
	}

	@Test
	@DisplayName("라인에 대한 포인트의 값에따라 위치 정보가 변경된다.")
	public void movePoint() {
		Point point = new Point(false);

		Assertions.assertThat(point.movePosition(0, true)).isEqualTo(1);
	}

}