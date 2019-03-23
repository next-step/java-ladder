package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 겹치는라인제거() {
        int height = 5;

        Line line1 = new Line(height);
        Line line2 = new Line(height);
        line1.checkLine(line2);
        assertThat(line1.checkLineDuplicata(line2)).isFalse();
    }
}