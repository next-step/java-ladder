package ladder;


import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineTest {
    @Test
    void When_New_Then_Created() {
        assertDoesNotThrow(() -> {
            new Line(2);
        });
    }

    @Test
    void When_Move_When_Moved() {
        Line line = new Line(2);
        assertDoesNotThrow(() -> {
            line.move(0);
        });
    }
}
