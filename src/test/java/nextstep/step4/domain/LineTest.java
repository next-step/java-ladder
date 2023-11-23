package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("Point List를 입력으로, Line 객체를 생성할 수 있다.")
    void testLineConstructor() {
        //given
        List<Point> points = List.of(Point.first(true).next(false), Point.first(true).next(false));

        //when
        Line line = new Line(points);

        //then
        assertThat(line).isNotNull();
    }

}
