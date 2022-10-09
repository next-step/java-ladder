package nextstep.laddergame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    public void line_size_test() {
        int length = 4;
        Line line = new Line(length);
        assertThat(line.getLadderPieces()).hasSize(length);
    }
}