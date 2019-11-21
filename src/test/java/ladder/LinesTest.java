package ladder;

import ladder.domain.Line;
import ladder.domain.Lines;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    void 라인들_생성() {
        List<Line> lineCollection = Arrays.asList(new Line(5));

        Lines lines = new Lines(lineCollection);
        assertThat(lines).isEqualTo(new Lines(lineCollection));
    }

    @Test
    void 라인들_생성_사다리높이_참여자수() {
        Lines lines = new Lines(5, 4);

        assertThat(lines.getSize()).isEqualTo(5);
    }

    @Test
    void 라인들_이동_한명() {
        Lines lines = new Lines(3, 3);

        assertThat(lines.move(2)).isIn(0, 1, 2);
    }
}
