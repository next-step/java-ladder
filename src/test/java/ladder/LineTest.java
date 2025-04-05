package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    Point notConnected = new Point(false);
    Point connected = new Point(true);

    @Test
    void 라인_생성() {
        Line line = new Line(4, (idx) -> false);
        assertThat(line).isEqualTo(new Line(List.of(notConnected, notConnected, notConnected, notConnected)));
    }

    @Test
    void 처음에만_연결() {
        Line line = new Line(4, (idx) -> idx == 0);
        assertThat(line).isEqualTo(new Line(List.of(connected, notConnected, notConnected, notConnected)));
    }

    @Test
    void 홀수번째만_연결() {
        Line line = new Line(4, (idx) -> idx % 2 != 0);
        assertThat(line).isEqualTo(new Line(List.of(notConnected, connected, notConnected, connected)));
    }

    @Test
    void 연속적으로_연결되면_예외() {
        assertThatThrownBy(() -> new Line(4, (idx) -> true)).isInstanceOf(IllegalArgumentException.class);
    }
}
