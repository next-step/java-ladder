package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class LineTest {

    @Test
    void create() {
        Line line = Line.of(Arrays.asList(new Point(false, true)));
        assertThat(line.getPoints().size()).isEqualTo(1);
    }
}