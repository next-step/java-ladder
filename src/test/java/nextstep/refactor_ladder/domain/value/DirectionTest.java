package nextstep.refactor_ladder.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

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
            assertSame(Direction.first(true), Direction.of(false, true));
            assertSame(Direction.first(false), Direction.of(false, false));
        });
    }

    @Test
    @DisplayName("마지막인 경우 오른쪽 값은 무조건 거짓으로 설정 검증")
    void last() {
        assertAll(() -> {
            assertSame(Direction.of(false, false).last(), Direction.of(false, false));
            assertSame(Direction.of(false, true).last(), Direction.of(true, false));
        });
    }

    @Test
    @DisplayName("왼쪽값이 참이면 오른쪽 값은 무조건 거짓 검증")
    void next() {
        assertSame(Direction.first(true).next(() -> false), Direction.of(true, false));
    }

    @Test
    @DisplayName("왼쪽값이 거짓이면 오른쪽 값은 참 또는 거짓 검증")
    void next2() {
        assertAll(() -> {
            assertSame(Direction.first(false).next(() -> false), Direction.of(false, false));
            assertSame(Direction.first(false).next(() -> true), Direction.of(false, true));
        });
    }
}
