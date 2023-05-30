package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrossTest {

    @Test
    void right() {
        Point right = Point.first(true);
        Cross cross = new Cross(1, right);
        Assertions.assertThat(cross.move()).isEqualTo(2);
    }

    @Test
    void left() {
        Point left = Point.first(true).next(false);
        Cross cross = new Cross(1, left);
        Assertions.assertThat(cross.move()).isEqualTo(0);
    }

    @Test
    void south() {
        Point south = Point.first(false);
        Cross cross = new Cross(1, south);
        Assertions.assertThat(cross.move()).isEqualTo(1);
    }
}
