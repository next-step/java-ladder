package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 라인_생성() {
        Line line = new Line(4, (idx) -> false);
        assertThat(line).isEqualTo(new Line(List.of(false, false, false, false)));
    }

    @Test
    void 처음에만_연결() {
        Line line = new Line(4, (idx) -> idx == 0);
        assertThat(line).isEqualTo(new Line(List.of(true, false, false, false)));
    }

    @Test
    void 홀수번째만_연결() {
        Line line = new Line(4, (idx) -> idx % 2 != 0);
        assertThat(line).isEqualTo(new Line(List.of(false, true, false, true)));
    }
}
