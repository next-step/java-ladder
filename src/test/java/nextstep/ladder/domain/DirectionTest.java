package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

  @Test
  @DisplayName("양쪽 모두 true 이면 Exception")
  void create_exception() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Direction.of(true, true))
        .withMessage("Neither can be true.");
  }

  @Test
  @DisplayName("처음 Direction 은 left 일 수 없다.")
  void first() {
    Direction first = Direction.first(() -> true);
    assertThat(first.isLeft()).isFalse();
  }

  @Test
  @DisplayName("처음 Direction 은 right 일 수 없다.")
  void last() {
    Direction direction = Direction.of(false, true);
    Direction last = direction.last();
    assertThat(last.isRight()).isFalse();
  }

  @Test
  @DisplayName("이전 direction right 가 다음 direction 의 left 값으로 생성된다.")
  void next() {
    Direction direction = Direction.of(false, false);
    Direction next = direction.next(() -> true);
    assertThat(next.isLeft()).isFalse();
  }

  @Test
  @DisplayName("left 가 true 일 경우, right 는 무조건 false")
  void next_left_true() {
    Direction direction = Direction.of(false, true);
    Direction next = direction.next(() -> true);
    assertThat(next.isRight()).isFalse();
  }

  @Test
  @DisplayName("left 가 false 일 경우, direction 을 생성한다.")
  void next_left_false() {
    Direction direction = Direction.of(false, false);
    Direction next = direction.next(() -> true);
    assertThat(next.isRight()).isTrue();
  }
}