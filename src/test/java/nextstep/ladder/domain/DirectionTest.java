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
        Direction direction = Direction.right(() -> true);
        assertThat(direction.isRight()).isTrue();
    }

    @DisplayName("왼쪽 Direction 생성")
    @Test
    void createLeftDirection() {
        Direction direction = Direction.left();
        assertThat(direction.isLeft()).isTrue();
    }

    @DisplayName("현재 방향이 왼쪽일 때 다음 Direction 생성")
    @Test
    void nextDirectionBaseLeft() {
        Direction next = Direction.left().next();
        assertThat(next.isLeft()).isFalse();
    }

    @DisplayName("현재 방향이 오른쪽일 때 다음 Direction 생성")
    @Test
    void nextDirectionBaseRight() {
        Direction next = Direction.right(() -> true).next();
        assertThat(next.isLeft()).isTrue();
    }
}
