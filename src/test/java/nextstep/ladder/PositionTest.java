package nextstep.ladder;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    void 이동_테스트() {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(true);
        points.add(point);
        point = point.next(false);
        points.add(point);
        point = point.last();
        points.add(point);

        Position positionRight = new Position(0);
        assertThat(positionRight.move(points).getX()).isEqualTo(1);
        Position positionLeft = new Position(1);
        assertThat(positionLeft.move(points).getX()).isEqualTo(0);
        Position psitionDown = new Position(2);
        assertThat(psitionDown.move(points).getX()).isEqualTo(2);
    }
}
