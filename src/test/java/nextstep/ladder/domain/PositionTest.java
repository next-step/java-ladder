package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    @DisplayName("Position은 최솟 값보다 작으면 예외를 던진다.")
    void newObject_lessThanMin_throwsException() {
        assertThatThrownBy(
                () -> new Position(Position.MIN_VALUE - 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Position은 최댓값 보다 크면 예외를 던진다.")
    void newObject_moreThanMax_throwsException() {
        assertThatThrownBy(
                () -> new Position(Position.MAX_VALUE + 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("left는 현재보다 한칸 왼쪽의 객체를 반환한다.")
    void left_leftPosition() {
        int current = 5;
        Position position = new Position(current);
        Position leftPosition = position.left();
        assertThat(leftPosition.current()).isEqualTo(current - 1);
    }

    @Test
    @DisplayName("right는 현재보다 한칸 오른쪽 객체를 반환한다.")
    void right_rightPosition() {
        int current = 5;
        Position position = new Position(current);
        Position rightPosition = position.right();
        assertThat(rightPosition.current()).isEqualTo(current + 1);
    }
}
