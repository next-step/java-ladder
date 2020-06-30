package ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PositionTest {

    @DisplayName("0보다 작으면 오류 발생")
    @Test
    void valueOfInvalidValue() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Position.valueOf(-1));
    }

    @DisplayName("입력한 숫자를 반환")
    @Test
    void getValue() {
        Position position = Position.valueOf(1);
        assertThat(position.getValue()).isEqualTo(1);
    }

    @DisplayName("1을 뺀 Position을 반환")
    @Test
    void left() {
        Position position = Position.valueOf(1);
        assertThat(position.left()).isEqualTo(Position.valueOf(0));
    }

    @DisplayName("1을 더한 Position을 반환")
    @Test
    void right() {
        Position position = Position.valueOf(1);
        assertThat(position.right()).isEqualTo(Position.valueOf(2));
    }
}
