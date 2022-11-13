package nextstep.ladder.domain;

import nextstep.ladder.codeleesh.domain.Line;
import nextstep.ladder.codeleesh.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("사다리의 한 라인 테스트")
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

        final Map<Integer, Integer> convert = line.convert();

        assertAll(
                () -> assertThat(convert).containsEntry(0, 1),
                () -> assertThat(convert).containsEntry(1, 0),
                () -> assertThat(convert).containsEntry(2, 3),
                () -> assertThat(convert).containsEntry(3, 2)
        );
    }
}
