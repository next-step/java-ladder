package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @DisplayName("포인트는 방향 데이터를 저장한다.")
    @Test
    void direction() {
        Point point = new Point();
        point.setLeftDirection(true);
        assertThat(point.hasLeftDirection()).isTrue();
        assertThat(point.hasRightDirection()).isFalse();
    }

    @DisplayName("양방향 다 가질 수 없다.")
    @Test
    void notTwoWayDirection() {
        Point point = new Point();
        point.setLeftDirection(true);
        point.setRightDirection(true);
        assertThat(point.hasLeftDirection()).isTrue();
        assertThat(point.hasRightDirection()).isFalse();
    }
}
