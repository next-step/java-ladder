package finalRefactor;

import finalRefactor.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @Test
    @DisplayName("초기화")
    void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("왼쪽, 오른쪽이 true 일 경우 에러 테스트")
    void invalid() {
        assertThatThrownBy(
                () -> Direction.of(true, true)
        );
    }

    @Test
    @DisplayName("첫번째 정보 테스트")
    void first() {
        Direction first = Direction.first(true);
        assertThat(first).isEqualTo(Direction.of(false, true));
    }

    @Test
    @DisplayName("다음 위치 테스트")
    void next() {
        assertThat(Direction.first(false).next(true)).isEqualTo(Direction.of(false,true));
    }

    @Test
    @DisplayName("마지막 위치 테스트")
    void last() {
        assertThat(Direction.of(false, true).last()).isEqualTo(Direction.of(true, false));
    }
}
