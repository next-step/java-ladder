package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void init() {
        Line compare = new Line(Arrays.asList(true,false,false,false));
        Line original = Line.of(4);
        original.initialize(compare);
        assertThat(original.getPoints()).contains(false);
    }
}
