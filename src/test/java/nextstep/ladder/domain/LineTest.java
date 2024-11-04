package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LineTest {

    @DisplayName("객체 생성이 잘 되는지")
    @Test
    void create() {
        assertDoesNotThrow(() -> Line.createLine(5));
    }

    @DisplayName("유효하지 않은 위치에 가로선을 그리면 예외가 잘 발생하는지")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void drawLine_AtInvalidPosition(int invalidPosition) {
        Line line = Line.createLine(5);
        assertThatThrownBy(() -> line.drawLine(invalidPosition))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연속된 가로선이 그려지지 않는지")
    @Test
    void drawLine_Continuous() {
        Line line = Line.createLine(5);
        line.drawLine(1);
        line.drawLine(2);
        assertThat(line.hasLine(1)).isTrue();
        assertThat(line.hasLine(2)).isFalse();
    }

    @DisplayName("그려진 선이 없을때 move 메서드가 동일한 위치를 반환하는지")
    @Test
    void moveTest_withNoLine() {
        Line line = Line.createLine(5);
        assertThat(line.move(0)).isEqualTo(0);
    }

    @DisplayName("왼쪽으로 이동할 수 있는지")
    @Test
    void moveTest_withLeftSide() {
        Line line = Line.createLine(5);
        line.drawLine(1);
        assertThat(line.move(2)).isEqualTo(1);
    }

    @DisplayName("오른쪽으로 이동할 수 있는지")
    @Test
    void moveTest_withRightSide() {
        Line line = Line.createLine(5);
        line.drawLine(1);
        assertThat(line.move(1)).isEqualTo(2);
    }

}
