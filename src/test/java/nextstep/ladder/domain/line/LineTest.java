package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    static List<Point> oneWayConnectedPoints() {
        List<Point> points = separatedPoints(4);

        points.get(3)
              .connectTo(points.get(2));

        return points;
    }

    static List<Point> separatedPoints(int limit) {
        return Stream.generate(Point::new)
                     .limit(limit)
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

    @Test
    @DisplayName("지점 간 연결 정보를 담은 객체를 추출한다.")
    void extractConnection() {
        List<Point> points = separatedPoints(8);
        points.get(1)
              .connectTo(points.get(2));
        points.get(2)
              .connectTo(points.get(1));

        points.get(4)
              .connectTo(points.get(5));
        points.get(5)
              .connectTo(points.get(4));

        Line line = new Line(points);

        // 0 1, 1 2, 2 3, 3 4, 4 5, 5 6, 6 7
        Connections connections = new Connections(
            Arrays.asList(false, true, false, false, true, false, false)
        );

        assertThat(line.extractConnections()).isEqaulTo(connections);
    }

}
