package laddergame;

import laddergame.domain.line.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("Line 생성 테스트")
    @Test
    void lineConstructorTest() {
        Line line = new Line(5, () -> true);
        assertThat(line.getLine().size()).isEqualTo(5);
    }

    @DisplayName("Connecntion 생성 확률 테스트")
    @Test
    void connectionProbabilityTest() {
        Line line = new Line(2, () -> true);
        assertThat(line.getLine().get(0)).isTrue();
        assertThat(line.getLine().get(1)).isFalse();

        Line secondLine = new Line(2, () -> false);
        assertThat(secondLine.getLine().get(0)).isFalse();
        assertThat(secondLine.getLine().get(1)).isFalse();
    }

}
