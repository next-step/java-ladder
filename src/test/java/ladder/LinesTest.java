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
        lines = new Lines();
    }

    @Test
    void apply_메서드_테스트() {
        int lineCount = 5;
        for (int i = 0; i < lineCount; i++) {
            assertThat(lines.apply(new Line(4))).hasSize(i+1);
        }
        assertThat(lines.getLadderLines()).hasSize(5);
    }
}
