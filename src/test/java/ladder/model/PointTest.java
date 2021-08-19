package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	@DisplayName("라인에 대한 포인트를 생성한다.")
	public void createPoint() {
		Point point = new Point(false, true);

		assertThat(point).isEqualTo(new Point(false, true));
		assertThat(point.isLeft()).isFalse();
		assertThat(point.isRight()).isTrue();
	}

	@Test
	@DisplayName("라인에 대한 포인트의 값에따라 위치 정보가 변경된다.")
	public void movePoint() {
		Point point = new Point(false, true);

		assertThat(point.movePosition(0)).isEqualTo(1);
	}

	@Test
	@DisplayName("양방향이 참일시 예외가 발생된다.")
	public void checkEmptyName() {
		assertThrows(IllegalStateException.class, () ->
			new Point(true, true)
		);
	}

}