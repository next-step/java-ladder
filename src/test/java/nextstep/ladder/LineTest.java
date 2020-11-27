package nextstep.ladder;

import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    void create() {
        // |-----|     |-----|
        Line line = new Line(VerticalLine.of(true, false, true));
    }
}
