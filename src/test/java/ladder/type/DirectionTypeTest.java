package ladder.type;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Point;

public class DirectionTypeTest {

	@DisplayName("좌표 객체를 이용해 방향 타입을 반환한다.")
	@Test
	void test1() {
		assertThat(DirectionType.of(Point.first(false).next(true))).isEqualTo(DirectionType.RIGHT);
		assertThat(DirectionType.of(Point.first(true).next(false))).isEqualTo(DirectionType.LEFT);
		assertThat(DirectionType.of(Point.first(false).next(false))).isEqualTo(DirectionType.DOWN);
	}
}
