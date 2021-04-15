package nextstep.refactoring.ladder.engine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("0 미만의 숫자는 사용항 수 없다.")
    void cannotUseUnder0() {
        assertThatThrownBy(() -> Position.of(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("왼쪽 위치")
    void getLeftPosition() {
        Position position = Position.of(1);

        assertThat(position.getLeft()).isEqualTo(Position.of(0));
    }

    @Test
    @DisplayName("오른쪽 위치")
    void getRightPosition() {
        Position position = Position.of(1);

        assertThat(position.getRight()).isEqualTo(Position.of(2));
    }
    
}
