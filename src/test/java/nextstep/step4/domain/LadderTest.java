package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("Line List를 입력으로, Ladder 객체를 생성할 수 있다.")
    void testLadderConstructor() {
        //given
        List<Point> points = List.of(Point.first(true).next(false), Point.first(true).next(false));
        Line line = new Line(points);

        //when
        final Ladder ladder = new Ladder(List.of(line));

        //then
        assertThat(ladder).isNotNull();
    }
}
