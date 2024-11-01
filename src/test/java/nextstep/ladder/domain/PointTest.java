package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @DisplayName("포인트가 최초 생성지 연결되지 않은 상태인지")
    @Test
    void createPoint_NotConnected() {
        Point point = Point.create();
        assertThat(point.isConnected()).isFalse();
    }

    @DisplayName("포인트 연결이 호출되면 연결상태가 되는지")
    @Test
    void connectPoint() {
        Point point = Point.create();
        point.connect();
        assertThat(point.isConnected()).isTrue();
    }
}
