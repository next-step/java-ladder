package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 로우추가() {
        int height = 5;

        Line line1 = new Line(height);
        line1.addRow(true);
        line1.addRow(true);
        line1.addRow(true);
        line1.addRow(true);
        line1.addRow(true);

        assertThat(line1.getRows()).hasSize(5);
    }

    @Test
    public void 겹치는라인() {
        int height = 1;

        Line line1 = new Line(height);
        line1.addRow(true);
        Line line2 = new Line(height);
        line2.addRow(true);

        assertThat(line1.changeLine(line2, 0)).isTrue();
    }

    @Test
    public void 안겹치는라인() {
        int height = 1;

        Line line1 = new Line(height);
        line1.addRow(true);
        Line line2 = new Line(height);
        line2.addRow(false);

        assertThat(line1.changeLine(line2, 0)).isFalse();
    }
}