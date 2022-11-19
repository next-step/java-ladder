package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void move() {
        Cross cross = Cross.first(true);
        Line line = new Line(List.of(cross, cross.last()));

        assertThat(line.move(0)).isOne();
    }

    @Test
    void stay() {
        Cross cross = Cross.first(false);
        Line line = new Line(List.of(cross, cross.last()));

        assertThat(line.move(0)).isZero();
    }
}
