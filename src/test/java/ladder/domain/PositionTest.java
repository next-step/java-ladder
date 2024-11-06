package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    @DisplayName("왼쪽으로 이동 테스트")
    public void moveLeft() {
        Position position = new Position(1);
        position = position.moveLeft();
        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽으로 이동 테스트")
    public void moveRight() {
        Position position = new Position(0);
        position = position.moveRight();
        assertThat(position.getValue()).isEqualTo(1);
    }

}
