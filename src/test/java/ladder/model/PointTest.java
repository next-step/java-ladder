package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	@DisplayName("사다리의 포인트 좌표를 생성한다.")
	public void createPoint() {
		Point point = new Point(false, true);

		assertThat(point).isEqualTo(new Point(false, true));
		assertThat(point.isLeft()).isFalse();
		assertThat(point.isRight()).isTrue();
	}

	@Test
	@DisplayName("포인트의 값에따라 위치 정보가 변경된다.")
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

	@Test
	@DisplayName("첫번째 포인트가 생성된다.")
	public void initCreatePoint() {
		Point point = Point.initCreate(false);

		assertThat(point.movePosition(0)).isEqualTo(0);

		Point point2 = Point.initCreate(true);

		assertThat(point2.movePosition(0)).isEqualTo(1);
	}

	@Test
	@DisplayName("마지막 포인트가 생성된다.")
	public void initLastPoint() {
		Point point = Point.initCreate(false);
		point = point.initLast();
		assertThat(point.movePosition(0)).isEqualTo(0);

		Point point2 = Point.initCreate(true);
		point2 = point2.initLast();
		assertThat(point2.movePosition(1)).isEqualTo(0);
	}

	@Test
	@DisplayName("첫번째와 마지막 포인트가 아닌 부분을 생성한다.")
	public void initMiddlePoint() {
		Point point = Point.initCreate(false);
		point = point.next(false, false);
		assertThat(point.movePosition(0)).isEqualTo(0);

		Point point2 = Point.initCreate(true);
		point2 = point2.next(true, false);
		assertThat(point2.movePosition(1)).isEqualTo(0);
	}

}