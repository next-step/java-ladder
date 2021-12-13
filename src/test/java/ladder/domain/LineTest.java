package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(Arrays.asList(new Point(false, true), new Point(false, false)));
    }

    @Test
    @DisplayName("Line 생성자 테스트")
    void constructor() {
        assertThat(line)
                .isEqualTo(new Line(Arrays.asList(new Point(false, true), new Point(false, false))));
    }

    @Test
    @DisplayName("Line을 그리기 위해 사다리 line을 가져온다.")
    void getResultLine() {
        assertThat(line.getResultLine()).isEqualTo("    |-----|     ");
    }
}
