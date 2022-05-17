package ladder.domain;

import ladder.constant.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인의 좌표값이 연속으로 CONNECTED 일 경우 후자의 좌표값은 DISCONNECTED 가 된다.")
    void continuousConnected() {
        assertThat(new Line(List.of(Point.CONNECTED, Point.CONNECTED))).isEqualTo(new Line(List.of(Point.CONNECTED, Point.DISCONNECTED)));
    }
}
