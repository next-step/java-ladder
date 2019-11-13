package ladder;

import ladder.domain.Line;
import ladder.domain.Lines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    private Lines lines;

    @BeforeEach
    void setUp() {
        lines = new Lines(5, 4);
    }

    @Test
    void Lines테스트() {
        assertThat(lines.getLadderLines()).hasSize(5);
    }
}
