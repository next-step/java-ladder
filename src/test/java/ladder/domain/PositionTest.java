package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    @DisplayName("생성")
    @Test
    void create() {
        Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @DisplayName("음수 값으로 생성 시 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfInputIsNegativeNumber() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Position(-1)
        );
    }

    @DisplayName("move")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @CsvSource({"5, 1, 6", "5, -1, 4"})
    void move(int inputPosition, int moveValue, int expected) {
        Position position = new Position(inputPosition);
        Position result = position.move(moveValue);
        assertThat(result).isEqualTo(new Position(expected));
    }
}
