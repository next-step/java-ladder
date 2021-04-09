package nextstep.ladder.hint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

class DirectionTest {

    @DisplayName("방향 생성 테스트")
    @Test
    void init() {
        // given
        Direction actual = Direction.of(true, false);
        // when
        Direction expected = Direction.of(true, false);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("방향 생성시 예외 테스트")
    @Test
    void init_invalid() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> Direction.of(TRUE, TRUE));
    }

    @DisplayName("방향 first로 생성 시 next() 호출 값 확인 테스트")
    @Test
    void next_random_true() {
        // given
        Direction next = Direction.first(TRUE).next();
        // when
        Direction expected = Direction.of(TRUE, FALSE);
        // then
        assertThat(next).isEqualTo(expected);
    }

    @DisplayName("방향 생성 확인 테스트")
    @Test
    void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next();
        }
    }

    @DisplayName("방향 겹치지 않게 생성(TRUE, FALSE, TRUE) 확인 테스트")
    @Test
    void next_true() {
        // given
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        // when
        Direction expected = Direction.of(FALSE, TRUE);
        // then
        assertThat(next).isEqualTo(expected);
    }

    @DisplayName("방향 겹치지 않게 생성(FALSE, TRUE, FALSE) 확인 테스트")
    @Test
    void next_false() {
        // given
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        // when
        Direction expected = Direction.of(TRUE, FALSE);
        // then
        assertThat(next).isEqualTo(expected);
    }

    @DisplayName("방향 first() 생성 후 left 값 확인 테스트")
    @Test
    void first() {
        // given
        Direction first = Direction.first(TRUE);
        // when
        boolean actual = first.isLeft();
        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("방향 last() 호출 시 값 확인 테스트")
    @Test
    void last() {
        // given
        Direction last = Direction.first(TRUE).last();
        // when
        Direction expected = Direction.of(TRUE, FALSE);
        // then
        assertThat(last).isEqualTo(expected);
    }
}
