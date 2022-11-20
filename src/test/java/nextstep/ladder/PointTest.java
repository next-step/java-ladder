package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest{

    @Test
    void 점은_방향을_갖는다(){
        Point point = new Point(Direction.LEFT);
        assertThat(point.direction()).isEqualTo(Direction.LEFT);
    }
}
