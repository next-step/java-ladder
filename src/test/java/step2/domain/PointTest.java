package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

	@DisplayName("객체 생성 테스트")
	@Test
	void constructionTest() {
		Coordinate coordinate = new Coordinate(0);
		Direction direction = Direction.DOWN;
		assertThat(new Point(coordinate, direction)).isEqualTo(new Point(coordinate, direction));
	}


	@DisplayName("다음 가로 축 좌표로 이동하는 메서드 테스트")
	@ParameterizedTest
	@EnumSource(value = Direction.class)
	void goNextTest(Direction direction) {
		Coordinate coordinate = new Coordinate(direction.ordinal() + 1);
		Point point = new Point(coordinate, direction);
		Coordinate computed = direction.getNextCoordinate(coordinate);
		assertThat(point.goNextPoint()).isEqualTo(computed);
	}


}
