package nextstep.ladder.model;

import nextstep.ladder.model.v1.Line;
import nextstep.ladder.model.v1.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LinesTest {
    @Test
    @DisplayName("lines 동작 테스트")
    public void lines() {
        int HEIGHT = 3;
        Line leftLine = new Line(HEIGHT);
        Line rightLine = new Line(HEIGHT);
        Lines lines = new Lines(Arrays.asList(leftLine, rightLine));

        assertThat(lines.height()).isEqualTo(HEIGHT);
        assertThat(lines.hasLeftLine(0)).isFalse();
        assertThat(lines.hasLeftLine(1)).isTrue();
        assertThat(lines.getLeftLine(1)).isEqualTo(leftLine);
        assertThat(lines.hasRightLine(2)).isFalse();
        assertThat(lines.hasRightLine(0)).isTrue();
        assertThat(lines.getRightLine(1)).isEqualTo(rightLine);
    }
}