package ladder.domain;

import ladder.constant.Direction;
import ladder.constant.Point;
import ladder.constant.Type;
import ladder.exception.ContinuousConnectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(2, 1, "Tom", Type.UNFIXED);
    }

    @Test
    @DisplayName("참가자 수가 3명일 경우 2개의 좌표가 생긴다.")
    void create() {
        assertThat(new Line(3, count -> List.of(Point.CONNECTED, Point.DISCONNECTED)))
                .isEqualTo(new Line(Point.CONNECTED, Point.DISCONNECTED));
    }

    @Test
    @DisplayName("라인의 좌표값이 연속으로 CONNECTED 일 경우 ContinuousConnectionException 를 반환한다.")
    void continuousConnected() {
        assertThatThrownBy(() -> new Line(List.of(Point.CONNECTED, Point.CONNECTED)))
                .isInstanceOf(ContinuousConnectionException.class)
                .hasMessage("사다리 라인은 연속으로 연결될 수 없습니다.");
    }

    @Test
    @DisplayName("현재 위치에서 왼쪽으로 연결되어 있으면 Direction.LEFT 를 반환한다.")
    void directionLeft() {
        Line line = new Line(List.of(Point.CONNECTED, Point.DISCONNECTED));

        assertThat(line.direction(position.index())).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("현재 위치에서 오른쪽으로 연결되어 있으면 Direction.RIGHT 를 반환한다.")
    void directionRight() {
        Line line = new Line(List.of(Point.DISCONNECTED, Point.CONNECTED));

        assertThat(line.direction(position.index())).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("현재 위치에서 양쪽 다 연결되어 있지 않으면 Direction.STAY 를 반환한다.")
    void directionStay() {
        Line line = new Line(List.of(Point.DISCONNECTED, Point.DISCONNECTED));

        assertThat(line.direction(position.index())).isEqualTo(Direction.STAY);
    }
}
