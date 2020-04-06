package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {


    @DisplayName("포인트에서 다음 포인트로 이동하지 않으면 false를 반환한다")
    @Test
    void stopPoint() {
        Point point = new Point();
        assertThat(point.isNextPoint()).isFalse();
    }

    @DisplayName("포인트에서 다음 포인트로 이동할건지(선을 그으면) true를 반환한다.")
    @Test
    void movePoint() {
        Point point = new Point();
        point.moveNextPoint();
        assertThat(point.isNextPoint()).isTrue();
    }
}
