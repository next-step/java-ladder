package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(3);
    }

    @Test
    void 생성자비교() {
        Line line1 = new Line(3);
        assertThat(line1).isEqualTo(line);
    }
}
