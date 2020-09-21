package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first().move()).isBetween(0,1);
    }
}
