package nextstep.ladder.hint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class HintDirectionTest {

    @DisplayName("방향 생성 테스트")
    @Test
    void init() {
        // given
        HintDirection actual = HintDirection.of(true, false);
        // when
        HintDirection expected = HintDirection.of(true, false);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("방향 생성시 예외 테스트")
    @Test
    void init_invalid() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> HintDirection.of(TRUE, TRUE));
    }

    @DisplayName("방향 first로 생성 시 next() 호출 값 확인 테스트")
    @Test
    void next_random_true() {
        // given
        HintDirection next = HintDirection.first(TRUE).next();
        // when
        HintDirection expected = HintDirection.of(TRUE, FALSE);
        // then
        assertThat(next).isEqualTo(expected);
    }

    @DisplayName("방향 생성 확인 테스트")
    @Test
    void next_random_false() {
        for (int i = 0; i < 100; i++) {
            HintDirection.first(FALSE).next();
        }
    }

    @DisplayName("방향 겹치지 않게 생성(TRUE, FALSE, TRUE) 확인 테스트")
    @Test
    void next_true() {
        // given
        HintDirection next = HintDirection.of(TRUE, FALSE).next(TRUE);
        // when
        HintDirection expected = HintDirection.of(FALSE, TRUE);
        // then
        assertThat(next).isEqualTo(expected);
    }

    @DisplayName("방향 겹치지 않게 생성(FALSE, TRUE, FALSE) 확인 테스트")
    @Test
    void next_false() {
        // given
        HintDirection next = HintDirection.of(FALSE, TRUE).next(FALSE);
        // when
        HintDirection expected = HintDirection.of(TRUE, FALSE);
        // then
        assertThat(next).isEqualTo(expected);
    }

    @DisplayName("방향 first() 생성 후 left 값 확인 테스트")
    @Test
    void first() {
        // given
        HintDirection first = HintDirection.first(TRUE);
        // when
        boolean actual = first.isLeft();
        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("방향 last() 호출 시 값 확인 테스트")
    @Test
    void last() {
        // given
        HintDirection last = HintDirection.first(TRUE).last();
        // when
        HintDirection expected = HintDirection.of(TRUE, FALSE);
        // then
        assertThat(last).isEqualTo(expected);
    }
}
