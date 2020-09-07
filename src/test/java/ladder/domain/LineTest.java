package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    void Line_creation_test() {
        Participants participants = Participants.of("pobi,honux,crong,jk");
        Line line = Line.of(participants);

        int idx = 0;

        Point prev = line.getPoint(idx++);
        assertThat(prev.getLeft()).isFalse();

        while (!participants.isBeforeLast(idx)) {
            Point next = line.getPoint(idx++);
            assertThat(prev.getRight()).isEqualTo(next.getLeft());
            prev = next;
        }

        Point last = line.getPoint(idx);
        assertThat(last.getRight()).isFalse();
    }

    @Test
    void Line_exception_test() {
        String input = "pobi";
        assertThatThrownBy(() ->
                Line.of(Participants.of(input))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Line_move_test() {
        List<Point> points = new ArrayList<>();
        points.add(Point.ofFirstPoint(true));

        Line line = Line.of(points);

        int start = 0;
        int expected = start + 1;

        assertThat(line.move(start)).isEqualTo(expected);
    }
}
