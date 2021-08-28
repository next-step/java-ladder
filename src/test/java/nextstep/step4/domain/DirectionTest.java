package nextstep.step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import nextstep.step4.exception.InvalidDirectionException;

class DirectionTest {

	@DisplayName("각 지점의 방향을 갖는 Direction 객체를 생성한다.")
	@Test
	void create() {
		assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
	}

	@DisplayName("각 지점의 방향은 왼쪽과 오른쪽을 모두 가질 수 없다.")
	@Test
	void invalid() {
		assertThatThrownBy(() -> Direction.of(true, true))
			.isInstanceOf(InvalidDirectionException.class);
	}

	@DisplayName("첫 번째 지점의 방향은 오른쪽 또는 직선 방향만을 갖는다.")
	@Test
	void first() {
		Direction first = Direction.first(true);
		assertThat(first.isLeft()).isFalse();
		assertThat(first.isRight()).isTrue();
	}

	@DisplayName("이전 지점의 방향이 오른쪽이라면, 다음 지점의 방향은 왼쪽이다.")
	@Test
	void next1() {
		Direction next = Direction.first(true).next(false);
		assertThat(next).isEqualTo(Direction.of(true, false));
	}

	@DisplayName("이전 지점의 방향이 왼쪽 또는 직선이라면, 다음 지점의 방향은 오른쪽 또는 직선이다.")
	@CsvSource(value = {"false,true,true", "false,false,false", "true,true,true", "true,false,false"})
	@ParameterizedTest(name = "이전 지점 방향이 왼쪽인가? {0}, 다음 지점이 오른쪽인가? : {1}, 결과 : {2}")
	void next2(boolean isLeft, boolean isRight, boolean result) {
		Direction next = Direction.of(isLeft, false).next(isRight);
		assertThat(next).isEqualTo(Direction.of(false, result));
	}

	@DisplayName("마지막 지점의 방향은 왼쪽 또는 직선을 갖는다.")
	@CsvSource(value = {"true,true", "false,false"})
	@ParameterizedTest(name = "이전 지점 방향이 오른쪽인가? : {0}, 마지막 지점의 방향이 왼쪽인가? : {1}")
	void last(boolean isRight, boolean result) {
		Direction last = Direction.of(false, isRight).last();
		assertThat(last).isEqualTo(Direction.of(result, false));
	}

}
