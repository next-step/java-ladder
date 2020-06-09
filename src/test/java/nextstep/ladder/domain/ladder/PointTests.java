package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTests {
    @DisplayName("현재 위치와 Direction을 전달 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Point point = new Point(2, new Direction(false, false));
        assertThat(point).isNotNull();
    }
}
