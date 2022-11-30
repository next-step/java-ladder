package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.exception.IllegalDirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    void 점이_모여_선() {
        Line line = new Line(new Point(Direction.STRAIGHT));
        assertThat(line.line())
            .isEqualTo(asList(new Point(Direction.STRAIGHT)));
    }


    @Test
    @DisplayName("첫번째 점은 LEFT일 수 없다")
    void 첫번째점_예외() {
        List<Point> points = asList(new Point(Direction.LEFT), new Point(Direction.RIGHT), new Point(Direction.STRAIGHT));
        assertThatThrownBy(() -> new Line( points))
            .isInstanceOf(IllegalDirectionException.class);
    }

    @Test
    @DisplayName("중간점은 STRAIGT 제외 앞과 같은 방향일 수 없다")
    void 중간점_예외() {
        List<Point> points1 = asList(new Point(Direction.RIGHT), new Point(Direction.RIGHT), new Point(Direction.STRAIGHT));
        List<Point> points2 = asList(new Point(Direction.RIGHT), new Point(Direction.LEFT), new Point(Direction.LEFT), new Point(Direction.STRAIGHT));

        assertThatThrownBy(() -> new Line(points1))
            .isInstanceOf(IllegalDirectionException.class);

        assertThatThrownBy(() -> new Line(points2))
            .isInstanceOf(IllegalDirectionException.class);
    }

    @Test
    @DisplayName("마지막점이 RIGHT일 수 없다")
    void 마지막점_예외() {
        List<Point> points = asList(new Point(Direction.STRAIGHT), new Point(Direction.RIGHT), new Point(Direction.RIGHT));
        assertThatThrownBy(() -> new Line(points))
            .isInstanceOf(IllegalDirectionException.class);
    }

    @Test
    @DisplayName("선 안에 있는 점은 위치를 이동한다")
    void 위치_이동() {
        List<Point> points1 = asList(new Point(Direction.STRAIGHT), new Point(Direction.RIGHT), new Point(Direction.STRAIGHT));
        Line line1 = new Line(points1);

        int startAtFirst = line1.move(0);
        int startAtMiddle = line1.move(1);

        assertThat(startAtFirst).isEqualTo(0 + 1 + 0);
        assertThat(startAtMiddle).isEqualTo(1 + 0);


    }


}
