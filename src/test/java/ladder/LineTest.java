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
}
