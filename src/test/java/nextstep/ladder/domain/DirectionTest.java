package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {
    @DisplayName("Direction 생성")
    @Test
    void leftDirection() {
        boolean left = true;
        boolean right = false;
        Direction direction = Direction.of(left, right);
        assertThat(direction.isLeft()).isTrue();
    }

    @DisplayName("양쪽으로 방향을 가질 경우 throws Exception")
    @Test
    void invalidDirection() {
        boolean left = true;
        boolean right = true;
        assertThatIllegalArgumentException().isThrownBy(() -> Direction.of(left, right));
    }

    @DisplayName("오른쪽 Direction 생성")
    @Test
    void createRightDirection() {
        boolean left = false;
        boolean right = false;
        Direction direction = Direction.of(left, right).right(() -> true);
        assertThat(direction.isRight()).isTrue();
    }

    @DisplayName("왼쪽 Direction 생성")
    @Test
    void createLeftDirection() {
        boolean left = false;
        boolean right = false;
        Direction direction = Direction.of(left, right).left();
        assertThat(direction.isLeft()).isTrue();
    }
}
