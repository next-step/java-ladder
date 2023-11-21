package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void create() {
        Line line = new Line(Arrays.asList(true, false, true));
        assertThat(line).isEqualTo(new Line(Arrays.asList(true, false, true)));
    }

    @Test
    void toStringTest() {
        Line line = new Line(Arrays.asList(true, false, true));
        assertThat(line.toString()).isEqualTo("|-----|     |-----|");
    }

}
