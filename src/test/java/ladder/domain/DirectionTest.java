package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {
    @Test
    @DisplayName("생성 테스트")
    public void init() {
        assertThatCode(() -> Direction.of(true, false)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("left, right 값이 모두 true이면 IllegalStateException 발생")
    public void init_invalid() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalStateException.class);

    }

    @Test
    @DisplayName("이 전 값이 true이면 false를 반환한다. (라인 중복 방지) ")
    public void next_random_true() {
        Direction next = Direction.first(true).next();
        assertAll(
                () -> assertThat(next.isLeft()).isTrue(),
                () -> assertThat(next.isRight()).isFalse()
        );
    }

    @Test
    @DisplayName("next 인자가 true인경우 right값은 true이다")
    public void next_true() {
        Direction next = Direction.of(true, false).next(true);
        assertThat(next.isRight()).isTrue();
    }

    @Test
    @DisplayName("next 인자가 false인경우 right값은 false이다")
    public void next_false() {
        Direction next = Direction.of(false, true).next(false);
        assertThat(next.isRight()).isFalse();
    }

    @Test
    @DisplayName("첫번째 라인의 left값은 false이다")
    public void first() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    @DisplayName("마지막 라인의 right값은 false이다")
    public void last() {
        Direction last = Direction.first(true).last();
        assertThat(last.isRight()).isFalse();
    }

}
