package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    Point notConnected = new Point(false, false);
    Point connectOnlyLeft = new Point(true, false);
    Point connectOnlyRight = new Point(false, true);
    Point connectAll = new Point(true, true);

    @Test
    void 라인_생성() {
        Line line = new Line(4, (idx) -> notConnected);
        assertThat(line).isEqualTo(new Line(List.of(notConnected, notConnected, notConnected, notConnected)));
    }

    @Test
    void 처음에만_연결() {
        Line line = new Line(4, (idx) -> idx == 0 ? connectOnlyRight : notConnected);
        assertThat(line).isEqualTo(new Line(List.of(connectOnlyRight, notConnected, notConnected, notConnected)));
    }

    @Test
    void 홀수번째만_연결() {
        Line line = new Line(4, (idx) -> idx % 2 != 0 ? connectAll : notConnected);
        assertThat(line).isEqualTo(new Line(List.of(notConnected, connectAll, notConnected, connectAll)));
    }

    @Test
    void 연속적으로_연결되면_예외() {
        assertThatThrownBy(() -> new Line(4, (idx) -> connectAll)).isInstanceOf(IllegalArgumentException.class);
    }
}
