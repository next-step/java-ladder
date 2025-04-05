package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void 사람수보다_적은_사다리_생성() {
        Line line = new Line(3);
        assertThat(line.points()).hasSize(2);
    }

    @Test
    public void 가로가_연속해서_겹치지_않는다() {
        int countOfPerson = 10;

        Line line = new Line(countOfPerson);
        List<Point> points = line.points();

        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).hasRight()) {
                assertThat(points.get(i + 1).hasRight())
                    .isFalse();
            }
        }
    }

}
