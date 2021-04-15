package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Direction;
import ladder.domain.Point;

public class PointTest {

	@Test
	@DisplayName("First Point 생성")
	void first() {
		assertThat(Point.first(true).move()).isEqualTo(Direction.RIGHT);
		assertThat(Point.first(false).move()).isEqualTo(Direction.PASS);
	}

	@Test
	@DisplayName("Last Point 생성")
	void last() {
		assertThat(Point.first(true).last().move()).isEqualTo(Direction.LEFT);
		assertThat(Point.first(false).last().move()).isEqualTo(Direction.PASS);
	}

	@Test
	@DisplayName("비정상 포인트 생성 테스트")
	void invalid() {
		assertThatThrownBy(() -> {
			Point.first(true).next(true);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("Point에 연속된 True 값이 올 수 없습니다.");
	}

	@Test
	@DisplayName("아래 이동 테스트")
	void pass() {
		Point point = Point.first(false).next(false);
		assertThat(point.move()).isEqualTo(Direction.PASS);
	}

	@Test
	@DisplayName("왼쪽 이동 테스트")
	void left() {
		Point point = Point.first(true).next(false);
		assertThat(point.move()).isEqualTo(Direction.LEFT);
	}

	@Test
	@DisplayName("오른쪽 이동 테스트")
	void right() {
		Point point = Point.first(false).next(true);
		assertThat(point.move()).isEqualTo(Direction.RIGHT);
	}
}
