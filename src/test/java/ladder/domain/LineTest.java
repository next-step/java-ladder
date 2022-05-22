package ladder.domain;

import ladder.constant.Point;
import ladder.exception.ContinuousConnectionException;
import ladder.strategy.RandomGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    @DisplayName("참가자 수가 3명일 경우 2개의 좌표가 생긴다.")
    void create() {
        assertThat(new Line(new People("tom", "paul", "anna"), count -> List.of(Point.CONNECTED, Point.DISCONNECTED)))
                .isEqualTo(new Line(Point.CONNECTED, Point.DISCONNECTED));
    }

    @Test
    @DisplayName("라인의 좌표값이 연속으로 CONNECTED 일 경우 ContinuousConnectionException 를 반환한다.")
    void continuousConnected() {
        assertThatThrownBy(() -> new Line(List.of(Point.CONNECTED, Point.CONNECTED)))
                .isInstanceOf(ContinuousConnectionException.class)
                .hasMessage("사다리 라인은 연속으로 연결될 수 없습니다.");
    }
}
