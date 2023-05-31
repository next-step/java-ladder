package nextstep.ladder.domain.nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {


    @DisplayName("index가 1일때, 이전값이 true이고 현재 값이 false이면 0를 반환한다.")
    @Test
    void name() {
        Point point = new Point(1, new Direction(true, false));
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("index가 1일때, 이전값이 false 현재 값이 true이면 2를 반환한다.")
    @Test
    void name1() {
        Point point = new Point(1, new Direction(false, true));
        assertThat(point.move()).isEqualTo(2);
    }

    @DisplayName("index가 1일때, 이전값이 false이고 현재 값이 false이면 1를 반환한다.")
    @Test
    void name2() {
        Point point = new Point(1, new Direction(false, false));
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("index가 0일때 current 값이 true 일 경우 1 증가한 index를 반환한다.")
    @Test
    void name4() {
        Point point = new Point(0, Direction.first(true));
        assertThat(point.move()).isEqualTo(1);

    }

    @DisplayName("index가 0일때 current 값이 false 일 경우 원래 index를 반환한다.")
    @Test
    void name6() {
        Point point = new Point(0, Direction.first(false));
        assertThat(point.move()).isEqualTo(0);

    }

    @DisplayName("index가 max일때, previous 값이 true인 경우 1 감소한 index를 반환한다.")
    @Test
    void name5() {
        int maxIndex = 5;
        Point point = new Point(maxIndex, Direction.first(true).last());
        assertThat(point.move()).isEqualTo(maxIndex-1);
    }

    @DisplayName("index가 max일때, previous 값이 false인 경우 원래 index를 반환한다.")
    @Test
    void name7() {
        int maxIndex = 5;
        Point point = new Point(maxIndex, Direction.first(false).last());
        assertThat(point.move()).isEqualTo(maxIndex);
    }
}
