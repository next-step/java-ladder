package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(4);
    }

    @Test
    void 라인의포인트테스트() {
        line.test();
    }
}
