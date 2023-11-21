package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    void toStringTest() {
        final Line line1 = new Line(Arrays.asList(true, false, true));
        final Line line2 = new Line(Arrays.asList(false, true, false));
        final Lines lines = new Lines(Arrays.asList(line1, line2));

        assertThat(lines.toString()).isEqualTo("|-----|     |-----|\n|     |-----|     |\n");
    }
}