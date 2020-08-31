package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import laddergame.exception.LadderGameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

	@DisplayName("객체 생성 테스트")
	@Test
	void constructionTest() {
		int given = 1;
		assertThat(new Coordinate(given)).isEqualTo(new Coordinate(given));
	}

	@DisplayName("객체 생성 실패 테스트")
	@Test
	void constructionFailTest() {
		int given = -1;
		assertThrows(LadderGameException.class, () -> new Coordinate(given));
	}

	@DisplayName("decreaseCoordinate의 결과가 좌표값 1 감소인지 검증")
	@Test
	void decreaseCoordinate() {
		int given = 1;
		assertThat(new Coordinate(given).decreaseCoordinate()).isEqualTo(new Coordinate(given - 1));
	}

	@DisplayName("increaseCoordinate의 결과가 좌표값 1 증가인지 검증")
	@Test
	void increaseCoordinate() {
		int given = 1;
		assertThat(new Coordinate(given).increaseCoordinate()).isEqualTo(new Coordinate(given + 1));
	}

	@DisplayName("keepCoordinate의 결과가 좌표값 유지인지 검증")
	@Test
	void keepCoordinate() {
		int given = 1;
		assertThat(new Coordinate(given).keepCoordinate()).isEqualTo(new Coordinate(given));
	}
}
