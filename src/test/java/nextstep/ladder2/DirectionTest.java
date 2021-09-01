package nextstep.ladder2;

import nextstep.ladder2.domain.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DirectionTest {

    @Test
    @DisplayName("direction 생성 테스트")
    void directionCreateTest() {
        Direction direction = Direction.of(false, true);
        Assertions.assertAll(() -> {
            assertThat(direction.isLeft()).isFalse();
            assertThat(direction.isRight()).isTrue();
        });

    }

    @Test
    @DisplayName("direction 유효성 테스트")
    void directionExceptionTest() {
        assertThatThrownBy(() -> {
            Direction.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다음 direction 연결")
    void nextDirectionTest() {
        Direction direction = Direction.of(false, true);
        assertThat(direction.next(false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("다음 direction 유효성 테스트")
    void nextDirectionExceptionTest() {
        assertThatThrownBy(() -> {
            Direction.of(true, true).next(true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("첫번째 direction 테스트")
    void firstDirectionTest() {
        assertThat(Direction.first(true)).isEqualTo(Direction.of(false, true));
    }

    @Test
    @DisplayName("마지막 direction 테스트")
    void lastDirectionTest() {
        assertThat(Direction.of(false, true).last()).isEqualTo(Direction.of(true, false));
    }
}
