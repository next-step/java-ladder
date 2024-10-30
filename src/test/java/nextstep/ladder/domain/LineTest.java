package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("객체 생성이 잘 되는지")
    @Test
    void create() {
        Line line = Line.createLine(5);
        assertThat(line).isNotNull();
    }

    @DisplayName("유효하지 않은 위치에 가로선을 그리면 예외가 잘 발생하는지")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void drawLine_AtInvalidPosition(int invalidPosition) {
        Line line = Line.createLine(5);
        assertThatThrownBy(() -> line.drawLine(invalidPosition))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연속된 가로선이 그려지면 예외가 잘 발생하는지")
    @Test
    void drawLine_Continuous() {
        Line line = Line.createLine(5);
        line.drawLine(1);
        assertThatThrownBy(() -> line.drawLine(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
