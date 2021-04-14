package step4.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LadderLineTest {

    @Test
    public void validate() {
        // given
        int countOfPerson = 1;
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> LadderLine.init(countOfPerson));
    }

    @Test
    public void validate_2() {
        // given
        Point first = Point.first(true);
        List<Point> points = Arrays.asList(first);
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LadderLine(points));
    }

    @Test
    public void move() {
        // given
        Point first = Point.first(true);
        Point next = first.next(false);
        Point last = next.next(false);
        List<Point> points = Arrays.asList(first, next, last);
        LadderLine ladderLine = new LadderLine(points);
        // when & then
        assertThat(ladderLine.move(Position.valueOf(0))).isEqualTo(Position.valueOf(1));
        assertThat(ladderLine.move(Position.valueOf(1))).isEqualTo(Position.valueOf(0));
        assertThat(ladderLine.move(Position.valueOf(2))).isEqualTo(Position.valueOf(2));
    }
}
