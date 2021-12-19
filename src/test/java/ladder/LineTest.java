package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineTest {

    @Test
    @DisplayName("라인 생성")
    void createLine() {
        assertDoesNotThrow(() -> new Line(5));
    }

    @Test
    @DisplayName("라인 이동")
    void moveLine() {
        Line line = new Line(5);
        assertDoesNotThrow(() -> line.move(3));
    }
}
