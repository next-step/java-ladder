package nextstep.refactor_ladder.doamin.value;

import nextstep.refactor_ladder.domain.value.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DirectionTest {
    @Test
    @DisplayName("정상적인 방향 생성 테스트")
    void create() {
        assertAll(() -> {
            assertDoesNotThrow(() -> Direction.of(false, false));
            assertDoesNotThrow(() -> Direction.of(false, true));
            assertDoesNotThrow(() -> Direction.of(true, false));
        });
    }

    @Test
    @DisplayName("비 정상적인 방향 생성 테스트")
    void create_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> Direction.of(true, true));
    }

    @Test
    @DisplayName("시작인 경우 왼쪽 값은 무조건 거짓으로 설정 검증")
    void first() {
        assertAll(() -> {
            assertThat(Direction.first(true)).isEqualTo(Direction.of(false, true));
            assertThat(Direction.first(false)).isEqualTo(Direction.of(false, false));
        });
    }

    @Test
    @DisplayName("마지막인 경우 오른쪽 값은 무조건 거짓으로 설정 검증")
    void last() {
        assertAll(() -> {
            assertThat(Direction.of(false, false).last()).isEqualTo(Direction.of(false, false));
            assertThat(Direction.of(false, true).last()).isEqualTo(Direction.of(true, false));
        });
    }

    @Test
    @DisplayName("왼쪽값이 참이면 오른쪽 값은 무조건 거짓 검증")
    void next() {
        assertThat(Direction.first(true).next(() -> false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("왼쪽값이 거짓이면 오른쪽 값은 참 또는 거짓 검증")
    void next2() {
        assertAll(() -> {
            assertThat(Direction.first(false).next(() -> false)).isEqualTo(Direction.of(false, false));
            assertThat(Direction.first(false).next(() -> true)).isEqualTo(Direction.of(false, true));
        });
    }
}
