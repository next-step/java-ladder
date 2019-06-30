package nextstep.ladder;

import nextstep.ladder.model.Line;
import nextstep.ladder.view.LineFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineFormatterTest {
    private LineFormatter lineFormatter;
    private Line line;

    @BeforeEach
    void setUp() {
        lineFormatter = new LineFormatter();
        line = new Line(Arrays.asList(true, false, true, true));
    }

    @DisplayName("Line |-----|     |-----|-----|")
    @Test
    void formatTest() {

        assertThat(lineFormatter.format(line)).isEqualTo("     |-----|     |-----|-----|\n");
    }
}
