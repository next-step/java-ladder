package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class LineTest {

    @Test
    void create() {
        Line line = new Line(4, new RandomStrategy());
        assertThat(line.getPoints().size()).isEqualTo(4);
    }
}