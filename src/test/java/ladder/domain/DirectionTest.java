package ladder.domain;

import ladder.exception.InvalidDirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @Test
    @DisplayName("진행 가능 방향을 입력해서 direction 객체 생성")
    void createDirectionTest() {
        Direction direction = new Direction(true, false);
        assertThat(direction.isLeft()).isTrue();
        assertThat(direction.isRight()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("오른쪽 방향이면 index 에서 1 증가한다.")
    void isRightTest(int index) {
        Direction rightDirection = new Direction(false, true);
        int move = rightDirection.move(index);
        assertThat(move).isEqualTo(index + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("왼쪽 방향이면 index 에서 1 감소한다.")
    void isLeftTest(int index) {
        Direction leftDirection = new Direction(true, false);
        int move = leftDirection.move(index);
        assertThat(move).isEqualTo(index - 1);
    }

    @Test
    @DisplayName("양방향이 모두 true 이면 InvalidDirectionException 발생")
    void throwInvalidDirectionExceptionTest() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(InvalidDirectionException.class);
    }
}