package nextstep.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Line2Test {
    private static Line2 line;

    @BeforeAll
    static void setUpBeforeClass() {
        line = new Line2(
                Arrays.asList(new Cross(0, new Point(false, true)), new Cross(0, new Point(true, false)), new Cross(0, new Point(false, false)))
        );
    }

    @Test
    void move() {
        assertThat(line.move(0)).isEqualTo(1);
    }

}
