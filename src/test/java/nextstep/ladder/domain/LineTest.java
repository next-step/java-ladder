package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {

        final Point first = Point.first(true);
        final List<Point> points = List.of(first
                , first.next(false)
                , first.next(false).next(true)
                , first.next(false).next(true).next(false)
        );
        line = new Line(points);
    }

    /**
     *     0     1     2     3
     *     |-----|     |-----|
     *   꽝    5000  꽝    3000
     */
    @DisplayName("사다리 한 라인을 생성 후 이동결과를 확인한다.")
    @Test
    void verify_line() {

        final Point first = Point.first(true);
        final List<Point> points = List.of(first
                , first.next(false)
                , first.next(false).next(true)
                , first.next(false).next(true).next(false)
        );
        final Line line = new Line(points);
        final Map<Integer, Integer> convert = line.convert();

        assertAll(
                () -> assertThat(convert.get(0)).isEqualTo(1),
                () -> assertThat(convert.get(1)).isEqualTo(0),
                () -> assertThat(convert.get(2)).isEqualTo(3),
                () -> assertThat(convert.get(3)).isEqualTo(2)
        );
    }
}
