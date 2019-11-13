package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(4);
    }

    @Test
    void 라인_객체_테스트() {
        Line line2 = new Line(4);
        assertThat(line).isNotEqualTo(line2);
    }
}
