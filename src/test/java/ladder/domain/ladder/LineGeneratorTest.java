package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {

    @Test
    void 라인_생성() {
        // given
        int numberOfParticipant = 4;
        LineGenerator lineGenerator = new LineGenerator();

        // when
        HorizontalLine line = lineGenerator.generate(numberOfParticipant, () -> true);

        // then
        List<Point> points = new ArrayList<>();
        Point first = Point.first(() -> true);
        points.add(first);
        points.add(first.next(() -> true));
        points.add(first.next(() -> true).next(() -> true));
        points.add(first.next(() -> true).next(() -> true).last());

        assertThat(line).isEqualTo(new HorizontalLine(points));
    }
}