package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PointTest {

  @ParameterizedTest
  @CsvSource({"false,0", "true,1"})
  @DisplayName("head를 만든다, head는 왼쪽으로 이동할 수 없다.")
  void head(boolean headRight, int position) {
    // given
    final Point head = Point.head(headRight);

    // when
    final int actual = head.move();

    // then
    assertThat(actual).isEqualTo(position);
  }

  @ParameterizedTest
  @CsvSource({"true,false,0", "false,false,1", "false,true,2"})
  @DisplayName("next를 만들고, next로 생성된 것은 모든 방향으로 이동가능하다.")
  void next(boolean headRight, boolean nextRight, int position) {
    // given
    final Point next = Point.head(headRight).next(nextRight);

    // when
    final int actual = next.move();

    // then
    assertThat(actual).isEqualTo(position);
  }

  @ParameterizedTest
  @CsvSource({"true,false,2", "false,false,2", "false,true,1"})
  @DisplayName("tail를 만들고, tail은 오른쪽으로 이동할 수 없다.")
  void tail(boolean headRight, boolean nextRight, int position) {
    // given
    final Point tail = Point.head(headRight).next(nextRight).tail();

    // when
    final int actual = tail.move();

    // then
    assertThat(actual).isEqualTo(position);
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  @DisplayName("이전 Point가 RIGHT면, 무조건 다음 Point는 LEFT여야한다.")
  void when_before_point_is_right_next_point_always_left(boolean nextRight) {
    // given
    final Point next = Point.head(true).next(nextRight);

    // when
    final int actual = next.move();

    // then
    assertThat(actual).isEqualTo(0);
  }
}
