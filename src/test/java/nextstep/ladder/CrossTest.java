package nextstep.ladder;

import nextstep.ladder.domain.Cross;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrossTest {

    @Test
    void left() {
        Point left = Point.first(true).next(false);
        Cross cross = new Cross(1, left);
        assertThat(cross.move()).isZero();
    }

    @Test
    void right() {
        Point right = Point.first(true);
        Cross cross = new Cross(1, right);
        assertThat(cross.move()).isEqualTo(2);
    }

    @Test
    void south() {
        Point south = Point.first(false).next(false);
        Cross cross = new Cross(1, south);
        assertThat(cross.move()).isOne();
    }
}
