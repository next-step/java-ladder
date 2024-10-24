package ladder2;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 최종_위치를_반환한다() {
        Position first = Position.first(true);
        Position next = first.next(false);
        Position last = next.last();
        Line line = new Line(List.of(first, next, last));

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
