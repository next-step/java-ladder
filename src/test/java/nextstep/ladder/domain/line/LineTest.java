package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    static List<Point> oneWayConnectedPoints() {
        List<Point> points = separatedPoints();

        points.get(3)
              .connectTo(points.get(2));

        return points;
    }

    static List<Point> separatedPoints() {
        return Stream.generate(Point::new)
                     .limit(4)
                     .collect(Collectors.toList());
    }

    @Test
    @DisplayName("라인이 가진 지점이 너무 적으면 예외 처리한다.")
    void throwExceptionIfLineHasFewPoints() {
        List<Point> emptyPointList = Collections.emptyList();
        List<Point> singlePointList = Collections.singletonList(new Point());

        assertAll(
            () -> assertThatThrownBy(() -> new Line(emptyPointList)).isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> new Line(singlePointList)).isInstanceOf(RuntimeException.class)
        );
    }

    @Test
    @DisplayName("단방향 연결된 지점이 있으면 예외 처리한다.")
    void throwExceptionLineHasOnyWayConnectedPoints() {
        List<Point> points = oneWayConnectedPoints();

        assertThatThrownBy(() -> new Line(points)).isInstanceOf(RuntimeException.class);
    }
}
