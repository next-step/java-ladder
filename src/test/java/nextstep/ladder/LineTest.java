package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 점이_모여_선(){
        Line line = new Line(new Point(Direction.LEFT));
        assertThat(line.points()).isEqualTo(Arrays.asList(new Point(Direction.LEFT)));
    }
}
